package com.jovision.netkit.mvp.data.bean.response;

/**
 * Copyright©中维世纪
 *
 * @author deli
 * 创建日期：2020/11/26
 * 描述：
 */
public class DeviceSmartTrackBean {



        /**
         * autoEnable : false
         * sens : 60
         * trace_sec : 20
         * reset_sec : 30
         */

        private boolean autoEnable;
        private int sens;
        private int trace_sec;
        private int reset_sec;

        public boolean isAutoEnable() {
            return autoEnable;
        }

        public void setAutoEnable(boolean autoEnable) {
            this.autoEnable = autoEnable;
        }

        public int getSens() {
            return sens;
        }

        public void setSens(int sens) {
            this.sens = sens;
        }

        public int getTrace_sec() {
            return trace_sec;
        }

        public void setTrace_sec(int trace_sec) {
            this.trace_sec = trace_sec;
        }

        public int getReset_sec() {
            return reset_sec;
        }

        public void setReset_sec(int reset_sec) {
            this.reset_sec = reset_sec;
        }
    }

