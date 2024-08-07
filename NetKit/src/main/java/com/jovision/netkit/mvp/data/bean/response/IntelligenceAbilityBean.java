package com.jovision.netkit.mvp.data.bean.response;

import java.io.Serializable;
import java.util.List;

//获取智能能力集
public class IntelligenceAbilityBean implements Serializable {

    private List<ChannelAbilityBean> channels;

    public List<ChannelAbilityBean> getChannels() {
        return channels;
    }

    public void setChannels(List<ChannelAbilityBean> channels) {
        this.channels = channels;
    }

    public static class ChannelAbilityBean implements Serializable {
        private int channelid;
        private List<AbilityBean> abilitys;

        public int getChannelid() {
            return channelid;
        }

        public void setChannelid(int channelid) {
            this.channelid = channelid;
        }

        public List<AbilityBean> getAbilitys() {
            return abilitys;
        }

        public void setAbilitys(List<AbilityBean> abilitys) {
            this.abilitys = abilitys;
        }
    }

    public static class AbilityBean implements Serializable {
        private String type;
        private String name;
        private int hashrate;
        private int status;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getHashrate() {
            return hashrate;
        }

        public void setHashrate(int hashrate) {
            this.hashrate = hashrate;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }

}
