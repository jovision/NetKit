package com.jovision.netkit.mvp.data.bean.response;

import java.util.ArrayList;
import java.util.List;

//获取预置点
public class OctPtzPresetsGetBean {

    private ResultBean result;
    private ErrorBean error;

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

    public static class ResultBean {

        private List<PresetBean> presetsList = new ArrayList<>();

        public List<PresetBean> getPresetsList() {
            return presetsList;
        }

        public void setPresetsList(List<PresetBean> presetsList) {
            this.presetsList = presetsList;
        }

        public static class PresetBean {
            private int presetno;
            private String name;

            public int getPresetno() {
                return presetno;
            }

            public void setPresetno(int presetno) {
                this.presetno = presetno;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }

}
