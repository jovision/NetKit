package com.jovision.netkit.mvp.data.bean.response;

import java.io.Serializable;

/**
 * @ProjectName: SAAS
 * @Package: com.jovision.saas.data.bean.response
 * @ClassName: SmartAppAlarmVoiceBean
 * @Description: java类作用描述
 * @CreateDate: 2024/6/11 09:37
 * @Version: 1.0
 */
public class SmartAppAlarmVoiceResBean implements Serializable {

    private Result result;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public static class Result{
        private boolean enable;
        private String sound_file;
        private int play_times;

        public boolean isEnable() {
            return enable;
        }

        public void setEnable(boolean enable) {
            this.enable = enable;
        }

        public String getSound_file() {
            return sound_file;
        }

        public void setSound_file(String sound_file) {
            this.sound_file = sound_file;
        }

        public int getPlay_times() {
            return play_times;
        }

        public void setPlay_times(int play_times) {
            this.play_times = play_times;
        }
    }
}
