package com.jovision.netkit.mvp.data.bean.response;

import android.os.Parcel;
import android.os.Parcelable;

public class TimeSlot implements Parcelable {
    private String startTime;
    private String endTime;
    private String week;//星期几 1：星期一 2：星期二 3：星期三 4：星期四 5：星期五 6：星期六 7: 星期日 == 星期几 MON：星期一 TUE：星期二 WEN：星期三 THU：星期四 FRI：星期五 SAT：星期六 SUN: 星期日

    public TimeSlot() {
    }

    public TimeSlot(String startTime, String endTime, String week) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.week = week;
    }

    protected TimeSlot(Parcel in) {
        startTime = in.readString();
        endTime = in.readString();
        week = in.readString();
    }

    public static final Creator<TimeSlot> CREATOR = new Creator<TimeSlot>() {
        @Override
        public TimeSlot createFromParcel(Parcel in) {
            return new TimeSlot(in);
        }

        @Override
        public TimeSlot[] newArray(int size) {
            return new TimeSlot[size];
        }
    };

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(startTime);
        dest.writeString(endTime);
        dest.writeString(week);
    }
}
