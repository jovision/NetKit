package com.jovision.netkit.mvp.util;

/**
 * Created by ZHP on 2017/10/24.
 */

import android.os.Environment;

import com.jovision.basekit.FileUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.Util;

/**
 * 5.0手机有点不支持ssl  1.2版本，要打开ssl版本支持
 * Abstract:
 */

public class HttpsUtil {

    public static class SSLParams
    {
        public SSLSocketFactory sSLSocketFactory;
        public X509TrustManager trustManager;
    }

    public static SSLParams getSslSocketFactory(InputStream[] certificates, InputStream bksFile, String password)
    {
        SSLParams sslParams = new SSLParams();
        try
        {
            TrustManager[] trustManagers = prepareTrustManager(certificates);
            KeyManager[] keyManagers = prepareKeyManager(bksFile, password);
            SSLContext sslContext = SSLContext.getInstance("TLS");
            X509TrustManager trustManager = null;
            if (trustManagers != null)
            {
                trustManager = new MyTrustManager(chooseTrustManager(trustManagers));
            } else
            {
                trustManager = new UnSafeTrustManager();
            }
            sslContext.init(keyManagers, new TrustManager[]{trustManager},null);
            sslParams.sSLSocketFactory = new Tls12SocketFactory(sslContext.getSocketFactory());
            sslParams.trustManager = trustManager;
            return sslParams;
        } catch (NoSuchAlgorithmException e)
        {
            throw new AssertionError(e);
        } catch (KeyManagementException e)
        {
            throw new AssertionError(e);
        } catch (KeyStoreException e)
        {
            throw new AssertionError(e);
        }
    }

    private class UnSafeHostnameVerifier implements HostnameVerifier
    {
        @Override
        public boolean verify(String hostname, SSLSession session)
        {
            return true;
        }
    }

    public static class UnSafeTrustManager implements X509TrustManager
    {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType)
                throws CertificateException
        {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType)
                throws CertificateException
        {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers()
        {
            return new X509Certificate[]{};
        }
    }

    private static TrustManager[] prepareTrustManager(InputStream... certificates)
    {
        if (certificates == null || certificates.length <= 0) return null;
        try
        {

            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null);
            int index = 0;
            for (InputStream certificate : certificates)
            {
                String certificateAlias = Integer.toString(index++);
                keyStore.setCertificateEntry(certificateAlias, certificateFactory.generateCertificate(certificate));
                try
                {
                    if (certificate != null)
                        certificate.close();
                } catch (IOException e){
                }
            }
            TrustManagerFactory trustManagerFactory = null;

            trustManagerFactory = TrustManagerFactory.
                    getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);

            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();

            return trustManagers;
        } catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        } catch (CertificateException e)
        {
            e.printStackTrace();
        } catch (KeyStoreException e)
        {
            e.printStackTrace();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;

    }

    private static KeyManager[] prepareKeyManager(InputStream bksFile, String password)
    {
        try
        {
            if (bksFile == null || password == null) return null;

            KeyStore clientKeyStore = KeyStore.getInstance("BKS");
            clientKeyStore.load(bksFile, password.toCharArray());
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(clientKeyStore, password.toCharArray());
            return keyManagerFactory.getKeyManagers();

        } catch (KeyStoreException e)
        {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        } catch (UnrecoverableKeyException e)
        {
            e.printStackTrace();
        } catch (CertificateException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    private static X509TrustManager chooseTrustManager(TrustManager[] trustManagers)
    {
        for (TrustManager trustManager : trustManagers)
        {
            if (trustManager instanceof X509TrustManager)
            {
                return (X509TrustManager) trustManager;
            }
        }
        return null;
    }


    private static class MyTrustManager implements X509TrustManager
    {
        private X509TrustManager defaultTrustManager;
        private X509TrustManager localTrustManager;

        public MyTrustManager(X509TrustManager localTrustManager) throws NoSuchAlgorithmException, KeyStoreException
        {
            TrustManagerFactory var4 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            var4.init((KeyStore) null);
            defaultTrustManager = chooseTrustManager(var4.getTrustManagers());
            this.localTrustManager = localTrustManager;
        }


        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException
        {

        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException
        {
            try
            {
                defaultTrustManager.checkServerTrusted(chain, authType);
            } catch (CertificateException ce)
            {
                localTrustManager.checkServerTrusted(chain, authType);
            }
        }


        @Override
        public X509Certificate[] getAcceptedIssuers()
        {
            return new X509Certificate[0];
        }
    }

    /**
     * 对4.x手机，支持SSL  "TLSv1.1", "TLSv1.2" 的兼容
     */
    public static class Tls12SocketFactory extends SSLSocketFactory {

        private final String[] TLS_SUPPORT_VERSION = {"TLSv1.1", "TLSv1.2"};
        final SSLSocketFactory delegate;

        public Tls12SocketFactory(){
            SSLContext sslContext = null;
            try {
                sslContext = SSLContext.getInstance("TLS");
                try {
                    sslContext.init(null, null, null);
                } catch (KeyManagementException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            delegate = sslContext.getSocketFactory();
        }


        public Tls12SocketFactory(SSLSocketFactory base) {
            this.delegate = base;
        }

        @Override
        public String[] getDefaultCipherSuites() {
            return delegate.getDefaultCipherSuites();
        }

        @Override
        public String[] getSupportedCipherSuites() {
            return delegate.getSupportedCipherSuites();
        }

        @Override
        public Socket createSocket(Socket s, String host, int port, boolean autoClose) throws IOException {
            return patch(delegate.createSocket(s, host, port, autoClose));
        }

        @Override
        public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
            return patch(delegate.createSocket(host, port));
        }

        @Override
        public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException, UnknownHostException {
            return patch(delegate.createSocket(host, port, localHost, localPort));
        }

        @Override
        public Socket createSocket(InetAddress host, int port) throws IOException {
            return patch(delegate.createSocket(host, port));
        }

        @Override
        public Socket createSocket(InetAddress address, int port, InetAddress localAddress, int localPort) throws IOException {
            return patch(delegate.createSocket(address, port, localAddress, localPort));
        }

        private Socket patch(Socket s) {
            if (s instanceof SSLSocket) {
                ((SSLSocket) s).setEnabledProtocols(TLS_SUPPORT_VERSION);
            }
            return s;
        }

    }
    /*
     * 方法名称：PutFile
     * 方法作用：上传文件
     */
    public static void PostFile(File file,String url, Callback callback) {
        try {
            InputStream inputStream = new FileInputStream(file);
            RequestBody requestBody = RequestBodyUtil.create(MediaType.parse("application/octet-stream"), inputStream);
            Request request = new Request.Builder().put(requestBody).url(url).build();
            OkHttpClient client = new OkHttpClient();
            client.newCall(request).enqueue(callback);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


    public static void PutFile(byte[] fileData,String url, String fileName, Callback callback) {
//        RequestBody fileBody = RequestBody.create(MediaType.parse("image/png"), file);
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        RequestBody requestBody;
        if (suffix.equalsIgnoreCase(".jpeg") || suffix.equalsIgnoreCase(".jpg")){
            requestBody = RequestBody.create(MediaType.parse("image/jpeg"), fileData);
        }else if (suffix.equalsIgnoreCase(".png")){
            requestBody= RequestBody.create(MediaType.parse("image/png"), fileData);
        }else{
            requestBody= RequestBody.create(MediaType.parse("image/png"), fileData);
        }
        Request request = new Request.Builder().put(requestBody).url(url).build();
        OkHttpClient client = new OkHttpClient.Builder().followRedirects(false).build();
        client.newCall(request).enqueue(callback);


    }

    public static void PutFile(File file,String url, Callback callback) {
//        RequestBody fileBody = RequestBody.create(MediaType.parse("image/png"), file);
        String fileName = file.getName();
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        RequestBody requestBody;
        if (suffix.equalsIgnoreCase(".jpeg") || suffix.equalsIgnoreCase(".jpg")){
            requestBody = RequestBody.create(MediaType.parse("image/jpeg"), FileUtil.readFile(file));
        }else if (suffix.equalsIgnoreCase(".png")){
            requestBody= RequestBody.create(MediaType.parse("image/png"), FileUtil.readFile(file));
        }else{
            requestBody= RequestBody.create(MediaType.parse("image/png"), FileUtil.readFile(file));
        }
        //传空串匹配后台的签名规则。
        requestBody= RequestBody.create(MediaType.parse(""), FileUtil.readFile(file));
        Request request = new Request.Builder().put(requestBody).url(url).build();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
//        builder.sslSocketFactory(AndroidHttpsHelper.geSocketFactory(), AndroidHttpsHelper.getTrustManager())
//                .hostnameVerifier(new HostnameVerifier() {
//                    @Override
//                    public boolean verify(String hostname, SSLSession session) {
//                        return true;
//                    }
//                });
        OkHttpClient client = builder.followRedirects(false).build();

        client.newCall(request).enqueue(callback);


    }

    public static void PutFileFeedBack(File file,String url, Callback callback) {
//        RequestBody fileBody = RequestBody.create(MediaType.parse("image/png"), file);
        String fileName = file.getName();
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        RequestBody requestBody;
        if (suffix.equalsIgnoreCase(".jpeg") || suffix.equalsIgnoreCase(".jpg")){
            requestBody = RequestBody.create(MediaType.parse("image/jpeg"), FileUtil.readFile(file));
        }else if (suffix.equalsIgnoreCase(".png")){
            requestBody= RequestBody.create(MediaType.parse("image/png"), FileUtil.readFile(file));
        }else{
            requestBody= RequestBody.create(MediaType.parse("image/png"), FileUtil.readFile(file));
        }
        //传空串匹配后台的签名规则。
        requestBody= RequestBody.create(MediaType.parse(""), FileUtil.readFile(file));
        Request request = new Request.Builder().put(requestBody).url(url).build();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
//        builder.sslSocketFactory(AndroidHttpsHelper.geSocketFactory(), AndroidHttpsHelper.getTrustManager())
//                .hostnameVerifier(new HostnameVerifier() {
//                    @Override
//                    public boolean verify(String hostname, SSLSession session) {
//                        return true;
//                    }
//                });
        OkHttpClient client = builder.followRedirects(false).build();

        client.newCall(request).enqueue(callback);


    }

    public static void putFileMulti(File file,String url, Callback callback){
        MediaType mediaType = MediaType.parse("image/png");//设置类型，类型为八位字节流
        RequestBody requestBody = RequestBody.create(mediaType, file);//把文件与类型放入请求体

        MultipartBody multipartBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("name", file.getName())
                .addFormDataPart("file", file.getName(), requestBody)//文件名,请求体里的文件
                .build();
        Request request = new Request.Builder().put(multipartBody).url(url).build();
        OkHttpClient client = new OkHttpClient();
        client.newCall(request).enqueue(callback);

    }

    public interface DownloadInterface {
        void  onDownloadSuccess();

        void onDownloadFailure();

        void onProgressUpdate(int progress);
    }
    public static void downloadFile(final String url, final String path,String fileName,final DownloadInterface downloadInterface) {
        if (null == url || !url.startsWith("http"))
            return;
        Request request = new Request.Builder().url(url).build();
        OkHttpClient client = new OkHttpClient();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                downloadInterface.onDownloadFailure();
            }

            @Override
            public void onResponse(Call call, Response response) {

                //创建文件夹
                FileUtil.createFolder(path);
                //输入流
                InputStream inputStream = null;
                //输出流
                FileOutputStream fileOutputStream = null;
                //每次读取的字节大小（缓冲流）
                byte readBytes[] = new byte[2048];
                //读取的长度(写入的长度)
                int length = 0;
                try {
                    //将服务器获取的文件传给输入流
                    inputStream = response.body().byteStream();
                    //获取文件总长度
                    long sumLength = response.body().contentLength();
                    //当前已下载长度
                    long nowLength=0;
                    //创建File对象 用于输出流创建文件
                    File file = new File(path+fileName);
                    if (file.exists()){
                        file.delete();
                        file.createNewFile();
                    }
                    //创建输出流
                    fileOutputStream = new FileOutputStream(file);
                    //循环将读到输入流的内容写入文件输出流
                    while ((length=inputStream.read(readBytes))!=-1) {
                        fileOutputStream.write(readBytes,0,length);
                        //累计已下载长度
                        nowLength+=length;
                        //下载进度更新的回调接口
                        downloadInterface.onProgressUpdate((int)(nowLength*1.0f/sumLength*100));
                    }
                    //把缓冲区的数据强行输出
                    fileOutputStream.flush();
                    //下载成功回调接口
                    downloadInterface.onDownloadSuccess();
                } catch (FileNotFoundException e) {
                    //下载失败回调接口
                    downloadInterface.onDownloadFailure();
                    e.printStackTrace();
                } catch (IOException e) {
                    //下载失败回调接口
                    downloadInterface.onDownloadFailure();
                    e.printStackTrace();
                } finally {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }
}
