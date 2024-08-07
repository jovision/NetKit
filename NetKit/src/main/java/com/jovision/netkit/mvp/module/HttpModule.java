package com.jovision.netkit.mvp.module;


import android.util.Log;

import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.jovision.basekit.JsonUtils;
import com.jovision.basekit.LogUtil;
import com.jovision.basekit.MMKVUtil;
import com.jovision.basekit.utilcode.AppUtils;
import com.jovision.basekit.utilcode.LogUtils;
import com.jovision.basekit.utilcode.Utils;
import com.jovision.netkit.mvp.Constant;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.RefreshTokenBean;
import com.jovision.netkit.mvp.data.bean.RefreshTokenResponseBean;
import com.jovision.netkit.mvp.data.bean.TokenCheckBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.net.rto_rxbuild.PersistentCookieStore;
import com.jovision.netkit.mvp.util.HttpsUtil;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import okio.Buffer;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import dagger.Module;
import dagger.Provides;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.JavaNetCookieJar;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import me.jessyan.retrofiturlmanager.RetrofitUrlManager;
import org.jetbrains.annotations.Nullable;

import static com.alibaba.fastjson.util.IOUtils.UTF8;

/**
 * Created by ZHP on 2017/6/Http
 */
@Module
public class HttpModule {

    public static final String TAG = "okhttp";

    PersistentCookieStore persistentCookieStore;
    private static OkHttpClient okHttpClient;

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient() {
        persistentCookieStore = new PersistentCookieStore(Utils.getApp());

        CookieHandler cookieHandler = new CookieManager(persistentCookieStore,
                CookiePolicy.ACCEPT_ALL);

        OkHttpClient.Builder builder = RetrofitUrlManager.getInstance()
                .with(new OkHttpClient.Builder());
//        builder.addInterceptor(new LogInterceptor());

//        //校验证书
//        LogUtil.v("https", "SocketFactory配置：" + AndroidHttpsHelper.geSocketFactory());
//        LogUtil.v("https", "TrustManager配置：" + AndroidHttpsHelper.getTrustManager());
//        builder.sslSocketFactory(AndroidHttpsHelper.geSocketFactory(), AndroidHttpsHelper.getTrustManager())
//                .hostnameVerifier(new HostnameVerifier() {
//                    @Override
//                    public boolean verify(String hostname, SSLSession session) {
//                        return true;
//                    }
//                });


        //不校验证书
        InputStream inputStream = null;
        String localName = "host.cer";
        try {
            inputStream = Utils.getApp().getAssets().open(localName);
        } catch (IOException e) {
            LogUtils.d("打开证书失败！");
            e.printStackTrace();
        }
        HttpsUtil.SSLParams sslParams = HttpsUtil.getSslSocketFactory(new InputStream[]{inputStream}, null, null);
        builder.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }

        }).sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager);


        okHttpClient = builder.addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        String token = MMKVUtil.getInstance().getToken();
                        Request request = chain.request()
                                .newBuilder()
                                .header("Content-Type", "application/json")
                                .header("Connection", "keep-alive")
                                .header("accept-language", "zh-CN")
                                .header("Accept", "*/*")
//                        .header("Authorization", "Bearer " + Constant.AC_SERVICE_ACCESS_TOKEN)
//                        .header("Authorization", "Bearer " + (StringUtil.isNullString(token) ? Constant.AC_SERVICE_ACCESS_TOKEN : token))
                                .header("Authorization", "Bearer " + token)
                                .build();

                        LogUtil.v(TAG, "Authorization-userToken,Bearer " + token);
                        return chain.proceed(request);
                    }
                }).addInterceptor(new LogInterceptor())
                // 连接超时时间设置
                .connectTimeout(20, TimeUnit.SECONDS)
                // 读取超时时间设置
                .readTimeout(20, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .cookieJar(new JavaNetCookieJar(cookieHandler))
                .build();
        return okHttpClient;


    }

    public void clearCookie() {
        persistentCookieStore.removeAll();
    }

    public class LogInterceptor implements Interceptor {

        public String TAG = "okhttp";

        @Override
        public Response intercept(Chain chain) throws IOException {

            Request request = chain.request();

            Response response = chain.proceed(chain.request());
            MediaType mediaType = response.body().contentType();
            Headers headers = response.networkResponse().request().headers();
            String content = response.body().string();
            LogUtil.v(TAG, "\n");
            LogUtil.v(TAG, "----------Start----------------");
            LogUtil.v(TAG, "| Request headers:" + request.headers().toString());
            LogUtil.v(TAG, "| Request url:" + request.url());
            LogUtil.v(TAG, "| Request Body:" + getRequestBodyStr(request));
            LogUtil.v(TAG, "| Response Body:" + content);
            LogUtil.v(TAG, " | response.isSuccessful()=" + response.isSuccessful());
            LogUtil.v(TAG, "----------End------------------");

            if (!response.isSuccessful()) {
                LogUtil.v(TAG, "----------End-s------------------");
                return response.newBuilder()
                        .body(okhttp3.ResponseBody.create(mediaType, content))
                        .build();
            }

            Response retryRequest = refreshToken(chain, content);

            if (retryRequest != null) {
                LogUtil.v(TAG, "----------End-s1------------------");
                String retryContent = retryRequest.body().string();
                MediaType retryMediaType = response.body().contentType();
                return retryRequest.newBuilder()
                        .body(okhttp3.ResponseBody.create(retryMediaType, retryContent))
                        .build();
            }

            LogUtil.v(TAG, "----------End-s2------------------");
            return response.newBuilder()
                    .body(okhttp3.ResponseBody.create(mediaType, content))
                    .build();
        }
    }

    @Nullable
    private Response refreshToken(Interceptor.Chain chain, String content) throws IOException {

        try {


            TokenCheckBean tokenCheckBean = JsonUtils.fromJson(content, TokenCheckBean.class);
            if (null != tokenCheckBean) {
//            if (tokenCheckBean.isTokenOverdue()){
//                RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),
//                        new Gson().toJson(new TikenBean(SharePreferencesUtils.getTiken())));
//                Request requestTiken = new Request.Builder().url(Constant.BASE_URL + Constant.refresh_token).post(body).build();
//                Call call = okHttpClient.newCall(requestTiken);
//                //同步请求
//                Response responseTiken = call.execute();
//                if (responseTiken.isSuccessful()) {
//                    TokenLifeBean tokenLifeBean = JsonUtils.fromJson(responseTiken.body().string(), TokenLifeBean.class);
//                    if (tokenLifeBean.getCode().equals(BaseBean.SUCCESS)) {
//                        String newToken = tokenLifeBean.getData().getToken();
//                        double tokenValidPeriod = tokenLifeBean.getData().getTokenValidPeriod();
//                        SharePreferencesUtils.saveToken(newToken,tokenValidPeriod);
//                        // 创建新的请求，并增加header
//                        Request retryRequest = chain.request()
//                                .newBuilder()
//                                .header("Authorization","Bearer " + newToken)
//                                .build();
//                        LogUtil.i(TAG, "\n");
//                        LogUtil.i(TAG, "----------Start----------------");
//                        LogUtil.i(TAG, "| 续约 Request headers:" + retryRequest.headers().toString());
//                        LogUtil.i(TAG, "| 续约 Request url:" +  retryRequest.url());
//                        LogUtil.i(TAG, "| 续约 Request Body:" + getRequestBodyStr(retryRequest));
//                        LogUtil.i(TAG, "| 续约 Response Body:" + chain.proceed(retryRequest).body().string());
//                        LogUtil.i(TAG, "----------End------------------");
//                        // 再次发起请求
//                        return chain.proceed(retryRequest);
//                    }
//                }
//            }else


                if (tokenCheckBean.isUnAuthorized()) {
                    synchronized (HttpModule.class) {
                        String authorization = chain.request().header("Authorization");
                        if (authorization.contains(MMKVUtil.getInstance().getToken())) {
                            //没有刷新
                            HashMap<String, String> attributes = new HashMap<>();
                            attributes.put("tenantId", Constant.tenantId);
                            RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),
                                    new Gson().toJson(new RefreshTokenBean(MMKVUtil.getInstance().getTiken(), attributes)));
                            Request requestTiken = new Request.Builder().url(Constant.BASE_URL + Constant.ac_refresh_token).post(body).build();
                            Call call = okHttpClient.newCall(requestTiken);
                            //同步请求
                            Response responseTiken = call.execute();
                            if (responseTiken.isSuccessful()) {
                                RefreshTokenResponseBean tokenResponseBean = JsonUtils.fromJson(responseTiken.body().string(), RefreshTokenResponseBean.class);
                                if (tokenResponseBean.getCode().equals(BaseBean.SUCCESS)) {
                                    String newToken = tokenResponseBean.getData().getAccessToken();
                                    double tokenValidPeriod = tokenResponseBean.getData().getAccessTokenExpire();
                                    MMKVUtil.getInstance().saveToken(newToken, tokenValidPeriod);
                                    // 创建新的请求，并增加header
                                    Request retryRequest = chain.request()
                                            .newBuilder()
                                            .header("Authorization", "Bearer " + newToken)
                                            .build();
                                    LogUtil.v(TAG, "\n");
                                    LogUtil.v(TAG, "----------Start----------------");
                                    LogUtil.v(TAG, "| 续约 Request headers:" + retryRequest.headers().toString());
                                    LogUtil.v(TAG, "| 续约 Request url:" + retryRequest.url());
                                    LogUtil.v(TAG, "| 续约 Request Body:" + getRequestBodyStr(retryRequest));
                                    LogUtil.v(TAG, "----------End------------------");
                                    // 再次发起请求
                                    return chain.proceed(retryRequest);
                                }
                            }
                        } else {
                            //刷新了
                            // 创建新的请求，并增加header
                            Request retryRequest = chain.request()
                                    .newBuilder()
                                    .header("Authorization", "Bearer " + MMKVUtil.getInstance().getToken())
                                    .build();
                            LogUtil.v(TAG, "\n");
                            LogUtil.v(TAG, "----------Start----------------");
                            LogUtil.v(TAG, "| 没有续约 Request headers:" + retryRequest.headers().toString());
                            LogUtil.v(TAG, "| 没有续约 Request url:" + retryRequest.url());
                            LogUtil.v(TAG, "| 没有续约 Request Body:" + getRequestBodyStr(retryRequest));
                            LogUtil.v(TAG, "----------End------------------");
                            // 再次发起请求
                            return chain.proceed(retryRequest);
                        }

                    }
                }

//            if (tokenCheckBean.isUnAuthorized()) {
//                synchronized (HttpModule.class){
//                    HashMap<String, String> attributes = new HashMap<>();
//                    attributes.put("tenantId", Constant.tenantId);
//                    RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),
//                            new Gson().toJson(new RefreshTokenBean(SharePreferencesUtils.getTiken(), attributes)));
//                    Request requestTiken = new Request.Builder().url(Constant.BASE_URL + Constant.ac_refresh_token).post(body).build();
//                    Call call = okHttpClient.newCall(requestTiken);
//                    //同步请求
//                    Response responseTiken = call.execute();
//                    if (responseTiken.isSuccessful()) {
//                        RefreshTokenResponseBean tokenResponseBean = JsonUtils.fromJson(responseTiken.body().string(), RefreshTokenResponseBean.class);
//                        if (tokenResponseBean.getCode().equals(BaseBean.SUCCESS)) {
//                            String newToken = tokenResponseBean.getData().getAccessToken();
//                            double tokenValidPeriod = tokenResponseBean.getData().getAccessTokenExpire();
//                            SharePreferencesUtils.saveToken(newToken, tokenValidPeriod);
//                            // 创建新的请求，并增加header
//                            Request retryRequest = chain.request()
//                                    .newBuilder()
//                                    .header("Authorization", "Bearer " + newToken)
//                                    .build();
//                            LogUtil.i(TAG, "\n");
//                            LogUtil.i(TAG, "----------Start----------------");
//                            LogUtil.i(TAG, "| 续约 Request headers:" + retryRequest.headers().toString());
//                            LogUtil.i(TAG, "| 续约 Request url:" + retryRequest.url());
//                            LogUtil.i(TAG, "| 续约 Request Body:" + getRequestBodyStr(retryRequest));
//                            LogUtil.i(TAG, "| 续约 Response Body:" + chain.proceed(retryRequest).body().string());
//                            LogUtil.i(TAG, "----------End------------------");
//                            // 再次发起请求
//                            return chain.proceed(retryRequest);
//                        }
//                    }
//
//                }
//            }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getRequestBodyStr(Request request) throws IOException {
        // body
        String body = "";
        RequestBody requestBody = request.body();
        boolean hasRequestBody = requestBody != null;
        if (!hasRequestBody) {
            LogUtil.v(TAG, "intercept: no requestBody");
        } else if (bodyEncoded(request.headers())) {
            LogUtil.v(TAG, "intercept: encoded requestBody omitted");
        } else {
            Buffer buffer = new Buffer();
            requestBody.writeTo(buffer);

            Charset charset = UTF8;
            MediaType contentType = requestBody.contentType();
            if (contentType != null) {
                charset = contentType.charset(UTF8);
            }

            if (isPlaintext(buffer)) {
                body = buffer.readString(charset);
                LogUtil.v(TAG, "intercept: (" + requestBody.contentLength() + "-byte body)");
            } else {
                LogUtil.v(TAG, "intercept: (binary "
                        + requestBody.contentLength() + "-byte requestBody omitted)");
            }
        }

        return body;
    }

    /**
     * Returns true if the body in question probably contains human readable text. Uses a small sample
     * of code points to detect unicode control characters commonly used in binary file signatures.
     */
    static boolean isPlaintext(Buffer buffer) {
        try {
            Buffer prefix = new Buffer();
            long byteCount = buffer.size() < 64 ? buffer.size() : 64;
            buffer.copyTo(prefix, 0, byteCount);
            for (int i = 0; i < 16; i++) {
                if (prefix.exhausted()) {
                    break;
                }
                int codePoint = prefix.readUtf8CodePoint();
                if (Character.isISOControl(codePoint) && !Character.isWhitespace(codePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException e) {
            return false; // Truncated UTF-8 sequence.
        }
    }

    private boolean bodyEncoded(Headers headers) {
        String contentEncoding = headers.get("Content-Encoding");
        return contentEncoding != null && !contentEncoding.equalsIgnoreCase("identity");
    }

    @Provides
    @Singleton
    public ApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient okHttpClient) {

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .callFactory(new CallFactoryProxy((Call.Factory) okHttpClient) {
                    @Override
                    protected @Nullable
                    HttpUrl getNewUrl(String baseUrlName, Request request) {
                        if (baseUrlName.equals("SAAS")) {
                            String oldUrl = request.url().toString();
                            String newUrl = oldUrl.replace(Constant.BASE_URL, Constant.SAAS_URL);
                            return HttpUrl.get(newUrl);
                        } else if (baseUrlName.equals("WEB_SERVICE_URL")) {
                            String oldUrl = request.url().toString();
                            String newUrl = oldUrl.replace(Constant.BASE_URL, Constant.WEB_SERVICE_URL);
//                            LogUtil.e("Sdfasdfsdaf-newUrl",newUrl);
                            return HttpUrl.get(newUrl);
                        }
                        return null;
                    }
                })
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());

        return builder.build();

    }

    public static OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    public void setOkHttpClient(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }


    public abstract class CallFactoryProxy implements Call.Factory {
        private static final String NAME_BASE_URL = "BaseUrlName";
        private static final String WEB_SERVICE_URL = "WebServiceUrl";
        private final Call.Factory delegate;

        public CallFactoryProxy(Call.Factory delegate) {
            this.delegate = delegate;
        }

        @Override
        public Call newCall(Request request) {
            String baseUrlName = request.header(NAME_BASE_URL);
            if (baseUrlName != null) {
                HttpUrl newHttpUrl = getNewUrl(baseUrlName, request);
                if (newHttpUrl != null) {
                    Request newRequest = request.newBuilder().url(newHttpUrl).build();
                    return delegate.newCall(newRequest);
                } else {
                    Log.w(TAG, "getNewUrl() return null when baseUrlName==" + baseUrlName);
                }
            }
            return delegate.newCall(request);
        }

        @Nullable
        protected abstract HttpUrl getNewUrl(String baseUrlName, Request request);
    }

}
