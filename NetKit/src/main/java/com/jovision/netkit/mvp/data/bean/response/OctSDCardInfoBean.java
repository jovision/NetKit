package com.jovision.netkit.mvp.data.bean.response;

import java.util.List;

/**
 * 2.0设备卡信息
 */
public class OctSDCardInfoBean {

    /**
     * method : storage_get_info
     * user : {"digest":"faece1a003c98c94d7e82b0b5fc06df2","name":"admin"}
     * result : {"disk":[{"diskNum":0,"devName":"TF Card","sizeMB":15193,"usedMB":2076,"bCurDisk":false,"partitionCount":0,"curPart":0,"status":"normal"}]}
     * error : {"errorcode":0}
     */

    private String method;
    private UserBean user;
    private ResultBean result;
    private ErrorBean error;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
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

    public static class UserBean {
        /**
         * digest : faece1a003c98c94d7e82b0b5fc06df2
         * name : admin
         */

        private String digest;
        private String name;

        public String getDigest() {
            return digest;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class ResultBean {
        private List<DiskBean> disk;

        public List<DiskBean> getDisk() {
            return disk;
        }

        public void setDisk(List<DiskBean> disk) {
            this.disk = disk;
        }

        public static class DiskBean {
            /**
             * diskNum : 0
             * devName : TF Card
             * sizeMB : 15193
             * usedMB : 2076
             * bCurDisk : false
             * partitionCount : 0
             * curPart : 0
             * status : normal
             */

            private int diskNum;
            private String devName;
            private int sizeMB;
            private int usedMB;
            private boolean bCurDisk;
            private int partitionCount;
            private int curPart;
            private String status;

            public int getDiskNum() {
                return diskNum;
            }

            public void setDiskNum(int diskNum) {
                this.diskNum = diskNum;
            }

            public String getDevName() {
                return devName;
            }

            public void setDevName(String devName) {
                this.devName = devName;
            }

            public int getSizeMB() {
                return sizeMB;
            }

            public void setSizeMB(int sizeMB) {
                this.sizeMB = sizeMB;
            }

            public int getUsedMB() {
                return usedMB;
            }

            public void setUsedMB(int usedMB) {
                this.usedMB = usedMB;
            }

            public boolean isBCurDisk() {
                return bCurDisk;
            }

            public void setBCurDisk(boolean bCurDisk) {
                this.bCurDisk = bCurDisk;
            }

            public int getPartitionCount() {
                return partitionCount;
            }

            public void setPartitionCount(int partitionCount) {
                this.partitionCount = partitionCount;
            }

            public int getCurPart() {
                return curPart;
            }

            public void setCurPart(int curPart) {
                this.curPart = curPart;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }
        }
    }

    public static class ErrorBean {
        /**
         * errorcode : 0
         */

        private int errorcode;

        public int getErrorcode() {
            return errorcode;
        }

        public void setErrorcode(int errorcode) {
            this.errorcode = errorcode;
        }
    }
}
