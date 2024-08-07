package com.jovision.netkit.mvp.data.bean;

public class FormatProgressBean {
    private boolean finished;//true
    private int progress;//100
    private String status;//normal、fail

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "FormatProgressBean{" +
                "finished=" + finished +
                ", progress=" + progress +
                ", status='" + status + '\'' +
                '}';
    }
}
