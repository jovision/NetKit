package com.jovision.netkit.mvp.data.bean.response;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;


import java.util.List;

/**
 * 获取osd参数
 *
 * @author liteng
 * @date 2022/11/28
 */
public class OctChnosdParamGetBean {

    /*
    {   // 获取osd参数
        "method": "chnosd_param_get",
            "level":"Operator",
            "param": {
        "channelid": 0 // 通道号，从0开始。
    },
        "result": {
        "OSDInfo": [
        {
            "type": "name,time,custom1",
                "bShowOSD": true,
                "text": "HD IPC",
                "position": "left_top,left_bottom,right_top,right_bottom,custom", // 特殊位置
                "fontSize": 32,
                "customPos":{ // position选用custom时生效
            "x":10, // 范围为 0~65535
                    "y":10 // 范围为 0~65535
        }
        }
			]
    },
        "error": {
        "errorcode": -1,
                "message": "Failed to get OSD parameters!"
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

        private boolean b751Adapt;//是否适配国标751协议

        private List<OSDInfoBean> OSDInfo;

        public List<OSDInfoBean> getOSDInfo() {
            return OSDInfo;
        }

        public void setOSDInfo(List<OSDInfoBean> OSDInfo) {
            this.OSDInfo = OSDInfo;
        }

        protected ResultBean(Parcel in) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                b751Adapt = in.readBoolean();
            } else {
                b751Adapt = in.readByte() != 0;
            }
            OSDInfo = in.createTypedArrayList(OSDInfoBean.CREATOR);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(@NonNull Parcel dest, int flags) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                dest.writeBoolean(b751Adapt);
            } else {
                dest.writeByte((byte) (b751Adapt? 1 : 0));
            }
            dest.writeTypedList(OSDInfo);
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

        public boolean isB751Adapt() {
            return b751Adapt;
        }

        public void setB751Adapt(boolean b751Adapt) {
            this.b751Adapt = b751Adapt;
        }

        public static class OSDInfoBean implements Parcelable {
            private String type;
            private boolean bShowOSD;
            private String text;
            private String position;
            private int fontSize;
            private CustomPosBean customPos;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public boolean isBShowOSD() {
                return bShowOSD;
            }

            public void setBShowOSD(boolean bShowOSD) {
                this.bShowOSD = bShowOSD;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public String getPosition() {
                return position;
            }

            public void setPosition(String position) {
                this.position = position;
            }

            public int getFontSize() {
                return fontSize;
            }

            public void setFontSize(int fontSize) {
                this.fontSize = fontSize;
            }

            public CustomPosBean getCustomPos() {
                return customPos;
            }

            public void setCustomPos(CustomPosBean customPos) {
                this.customPos = customPos;
            }

            protected OSDInfoBean(Parcel in) {
                type = in.readString();
                bShowOSD = in.readByte() != 0;
                text = in.readString();
                position = in.readString();
                fontSize = in.readInt();
                customPos = in.readParcelable(CustomPosBean.class.getClassLoader());
            }

            public OSDInfoBean() {
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(@NonNull Parcel dest, int flags) {
                dest.writeString(type);
                dest.writeByte((byte) (bShowOSD ? 1 : 0));
                dest.writeString(text);
                dest.writeString(position);
                dest.writeInt(fontSize);
                dest.writeParcelable(customPos, flags);
            }

            public static final Creator<OSDInfoBean> CREATOR = new Creator<OSDInfoBean>() {
                @Override
                public OSDInfoBean createFromParcel(Parcel in) {
                    return new OSDInfoBean(in);
                }

                @Override
                public OSDInfoBean[] newArray(int size) {
                    return new OSDInfoBean[size];
                }
            };

            public static class CustomPosBean implements Parcelable {
                private int x;
                private int y;

                private int endx;
                private int endy;


                public CustomPosBean(int x, int y) {
                    this.x = x;
                    this.y = y;
                }

                public CustomPosBean(int x, int y,int endx, int endy) {
                    this.x = x;
                    this.y = y;
                    this.endx = endx;
                    this.endy = endy;
                }


                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                protected CustomPosBean(Parcel in) {
                    x = in.readInt();
                    y = in.readInt();
                    endx = in.readInt();
                    endy = in.readInt();
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(@NonNull Parcel dest, int flags) {
                    dest.writeInt(x);
                    dest.writeInt(y);
                    dest.writeInt(endx);
                    dest.writeInt(endy);
                }

                public static final Creator<CustomPosBean> CREATOR = new Creator<CustomPosBean>() {
                    @Override
                    public CustomPosBean createFromParcel(Parcel in) {
                        return new CustomPosBean(in);
                    }

                    @Override
                    public CustomPosBean[] newArray(int size) {
                        return new CustomPosBean[size];
                    }
                };

                public int getEndx() {
                    return endx;
                }

                public void setEndx(int endx) {
                    this.endx = endx;
                }

                public int getEndy() {
                    return endy;
                }

                public void setEndy(int endy) {
                    this.endy = endy;
                }
            }

            /**
             * 获取type的描述
             * <p>
             * name: OSD内容;  time: OSD时间; custom0: 自定义1; ...;
             *
             * @return
             */
//            public String getTypeDescribe() {
//                String describe;
//                if (type == null) {
//                    describe = "";
//                } else if ("name".equals(type)) {
//                    describe = UIUtil.getString(R.string.dev_name);
//                } else if ("time".equals(type)) {
//                    describe = UIUtil.getString(R.string.dev_time);
//                } else if (type.startsWith("custom")) {
//                    // custom0 --> 自定义显示1
//                    describe = UIUtil.getString(R.string.custom_show);
//                    String indexStr = type.substring(6);
//                    try {
//                        int index = Integer.parseInt(indexStr);
//                        describe = describe + (index + 1);
//                    } catch (Exception e) {
//                        describe = describe + indexStr;
//                    }
//                } else {
//                    describe = type;
//                }
//                return describe;
//            }

            /**
             * 获取position的描述
             * <p>
             * left_top: 左上;  right_top: 右上;  custom: 自定义; ...;
             *
             * @return
             */
//            public String getPositionDescribe() {
//                String describe;
//                if (position == null) {
//                    describe = "";
//                } else if (position.equals("left_top")) {
//                    describe = UIUtil.getString(R.string.left_top);
//                } else if (position.equals("left_bottom")) {
//                    describe = UIUtil.getString(R.string.left_bottom);
//                } else if (position.equals("right_top")) {
//                    describe = UIUtil.getString(R.string.right_top);
//                } else if (position.equals("right_bottom")) {
//                    describe = UIUtil.getString(R.string.right_bottom);
//                } else if (position.equals("custom")) {
//                    describe = UIUtil.getString(R.string.custom);
//                } else {
//                    describe = position;
//                }
//                return describe;
//            }

            /**
             * type是否为自定义
             *
             * @return
             */
            public boolean isTypeCustom() {
                if (type.startsWith("custom")) {
                    return true;
                } else {
                    return false;
                }
            }
        }
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
