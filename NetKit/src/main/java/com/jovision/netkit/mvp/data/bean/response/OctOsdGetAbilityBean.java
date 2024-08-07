package com.jovision.netkit.mvp.data.bean.response;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 获取OSD能力
 *
 * @author liteng
 * @date 2022/12/7
 */
public class OctOsdGetAbilityBean {

    /*{	//获取OSD能力
        "method": "osd_get_ability",
        "level":"Operator",
        "param": {
            "channelid": 0
        },
        "result": {
                "AlarmFlickerSupport":true,	//是否支持报警联动配置osd报警闪烁
                "MultiOSDMaxFontSize": 55,	//多行OSD最大字号
                "MultiOSDMinFontSize": 1,	//多行OSD最小字号
                "MultiOSDMaxLine": 8,		//多行OSD最大行数
                "MultiOSDMaxWordsPerLine": 48		//多行OSD每行最大字符数
        },
        "error": {
        "errorcode": -32602,
                "message": "Failed to get osd ability parameters!"
        }
    }*/

    private String method;
    private String level;
    private ParamBean param;
    private ResultBean result;
    private ErrorBean error;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public ParamBean getParam() {
        return param;
    }

    public void setParam(ParamBean param) {
        this.param = param;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public ErrorBean getError() {
        return error;
    }

    public void setError(ErrorBean error) {
        this.error = error;
    }

    public static class ParamBean {

        private int channelid;

        public int getChannelid() {
            return channelid;
        }

        public void setChannelid(int channelid) {
            this.channelid = channelid;
        }
    }

    public static class ResultBean implements Parcelable {

        private boolean AlarmFlickerSupport;
        private int MultiOSDMaxFontSize;
        private int MultiOSDMinFontSize;
        private int MultiOSDMaxLine;
        private int MultiOSDMaxWordsPerLine = -1;

        public boolean isAlarmFlickerSupport() {
            return AlarmFlickerSupport;
        }

        public void setAlarmFlickerSupport(boolean AlarmFlickerSupport) {
            this.AlarmFlickerSupport = AlarmFlickerSupport;
        }

        public int getMultiOSDMaxFontSize() {
            return MultiOSDMaxFontSize;
        }

        public void setMultiOSDMaxFontSize(int MultiOSDMaxFontSize) {
            this.MultiOSDMaxFontSize = MultiOSDMaxFontSize;
        }

        public int getMultiOSDMinFontSize() {
            return MultiOSDMinFontSize;
        }

        public void setMultiOSDMinFontSize(int MultiOSDMinFontSize) {
            this.MultiOSDMinFontSize = MultiOSDMinFontSize;
        }

        public int getMultiOSDMaxLine() {
            return MultiOSDMaxLine;
        }

        public void setMultiOSDMaxLine(int MultiOSDMaxLine) {
            this.MultiOSDMaxLine = MultiOSDMaxLine;
        }

        public int getMultiOSDMaxWordsPerLine() {
            return MultiOSDMaxWordsPerLine;
        }

        public void setMultiOSDMaxWordsPerLine(int MultiOSDMaxWordsPerLine) {
            this.MultiOSDMaxWordsPerLine = MultiOSDMaxWordsPerLine;
        }

        protected ResultBean(Parcel in) {
            AlarmFlickerSupport = in.readByte() != 0;
            MultiOSDMaxFontSize = in.readInt();
            MultiOSDMinFontSize = in.readInt();
            MultiOSDMaxLine = in.readInt();
            MultiOSDMaxWordsPerLine = in.readInt();
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeByte((byte) (AlarmFlickerSupport ? 1 : 0));
            dest.writeInt(MultiOSDMaxFontSize);
            dest.writeInt(MultiOSDMinFontSize);
            dest.writeInt(MultiOSDMaxLine);
            dest.writeInt(MultiOSDMaxWordsPerLine);
        }

        public static final Creator<ResultBean> CREATOR = new Creator<ResultBean>() {
            @Override
            public ResultBean createFromParcel(Parcel in) {
                return new ResultBean(in);
            }

            @Override
            public ResultBean[] newArray(int size) {
                return new ResultBean[size];
            }
        };
    }

    public static class ErrorBean {
        private int errorcode;
        private String message;

        public int getErrorcode() {
            return errorcode;
        }

        public void setErrorcode(int errorcode) {
            this.errorcode = errorcode;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
