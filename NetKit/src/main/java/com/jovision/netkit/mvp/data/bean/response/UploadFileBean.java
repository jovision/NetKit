package com.jovision.netkit.mvp.data.bean.response;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class UploadFileBean implements Parcelable {
    private String filename;
    private String url;

    public UploadFileBean() {
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    protected UploadFileBean(Parcel in) {
        filename = in.readString();
        url = in.readString();
    }

    public static final Creator<UploadFileBean> CREATOR = new Creator<UploadFileBean>() {
        @Override
        public UploadFileBean createFromParcel(Parcel in) {
            return new UploadFileBean(in);
        }

        @Override
        public UploadFileBean[] newArray(int size) {
            return new UploadFileBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(filename);
        parcel.writeString(url);
    }
}
