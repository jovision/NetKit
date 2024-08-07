package com.jovision.netkit.mvp.data.bean.response;


//查询设备智能告警套餐开通详情
//http://172.18.3.246:3000/mock/382/v1/udms/device/smart_ability/detail
public class SmartAbilityDetailBean {
    private Babycryai babycryai;
    private Petai petai;

    public Petai getPetai() {
        return petai;
    }

    public void setPetai(Petai petai) {
        this.petai = petai;
    }

    public Babycryai getBabycryai() {
        return babycryai;
    }

    public void setBabycryai(Babycryai babycryai) {
        this.babycryai = babycryai;
    }


    public class Babycryai{
        private String expiration;//到期时间 yyyy-MM-dd
        private int remainDays;//剩余天数
        private int smartSwitch;//功能开关状态 0-关 1-是
        private int newDevice;//是否为新设备 0-否 1-是

        public String getExpiration() {
            return expiration;
        }

        public void setExpiration(String expiration) {
            this.expiration = expiration;
        }

        public int getRemainDays() {
            return remainDays;
        }

        public void setRemainDays(int remainDays) {
            this.remainDays = remainDays;
        }

        public int getSmartSwitch() {
            return smartSwitch;
        }

        public void setSmartSwitch(int smartSwitch) {
            this.smartSwitch = smartSwitch;
        }

        public int getNewDevice() {
            return newDevice;
        }

        public void setNewDevice(int newDevice) {
            this.newDevice = newDevice;
        }
    }

    public class Petai{
        private int status;//套餐开通状态，0-未开通、1-使用中、2-已停用、3-已过期
        private String expiration;//到期时间 yyyy-MM-dd
        private int remainDays;//剩余天数
        private int smartSwitch;//功能开关状态 0-关 1-是
        private int newDevice;//是否为新设备 0-否 1-是

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getExpiration() {
            return expiration;
        }

        public void setExpiration(String expiration) {
            this.expiration = expiration;
        }

        public int getRemainDays() {
            return remainDays;
        }

        public void setRemainDays(int remainDays) {
            this.remainDays = remainDays;
        }

        public int getSmartSwitch() {
            return smartSwitch;
        }

        public void setSmartSwitch(int smartSwitch) {
            this.smartSwitch = smartSwitch;
        }

        public int getNewDevice() {
            return newDevice;
        }

        public void setNewDevice(int newDevice) {
            this.newDevice = newDevice;
        }
    }

}
