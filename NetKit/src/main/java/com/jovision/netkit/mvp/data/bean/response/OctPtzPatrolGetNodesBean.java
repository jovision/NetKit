package com.jovision.netkit.mvp.data.bean.response;

import java.util.List;


//获取巡航节点
public class OctPtzPatrolGetNodesBean {

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
        private List<PatrolNodesListBean> patrolNodesList;

        public List<PatrolNodesListBean> getPatrolNodesList() {
            return patrolNodesList;
        }

        public void setPatrolNodesList(List<PatrolNodesListBean> patrolNodesList) {
            this.patrolNodesList = patrolNodesList;
        }

        public static class PatrolNodesListBean {
            private PresetBean preset;
            private int staySeconds;

            public PresetBean getPreset() {
                return preset;
            }

            public void setPreset(PresetBean preset) {
                this.preset = preset;
            }

            public int getStaySeconds() {
                return staySeconds;
            }

            public void setStaySeconds(int staySeconds) {
                this.staySeconds = staySeconds;
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
