package com.jovision.netkit.mvp.data.bean.response;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.List;

/**
 * 串货举报
 *
 * @author liteng
 * @date 2022/9/23
 */
public class CrossShipmentReportBean implements Parcelable {

    private String enterpriseName;
    private String contacts;
    private String phone;
    private String userRegion;
    private String crossRegion;
    private String enterpriseSite;
    /**
     * 提交时,图片路径列表
     */
    private List<String> photo;
    /**
     * 获取详情时,图片相关信息列表
     */
    private List<UploadFileBean> filenames;
    private String remarks;

    private String crossId;
    private int status;
    private String rejectReason;
    private String createTime;
    private String updateTime;
    private int readStatus;

    public CrossShipmentReportBean() {
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserRegion() {
        return userRegion;
    }

    public void setUserRegion(String userRegion) {
        this.userRegion = userRegion;
    }

    public String getCrossRegion() {
        return crossRegion;
    }

    public void setCrossRegion(String crossRegion) {
        this.crossRegion = crossRegion;
    }

    public String getEnterpriseSite() {
        return enterpriseSite;
    }

    public void setEnterpriseSite(String enterpriseSite) {
        this.enterpriseSite = enterpriseSite;
    }

    public List<String> getPhoto() {
        return photo;
    }

    public void setPhoto(List<String> photo) {
        this.photo = photo;
    }

    public List<UploadFileBean> getFilenames() {
        return filenames;
    }

    public void setFilenames(List<UploadFileBean> filenames) {
        this.filenames = filenames;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCrossId() {
        return crossId;
    }

    public void setCrossId(String crossId) {
        this.crossId = crossId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(int readStatus) {
        this.readStatus = readStatus;
    }

    protected CrossShipmentReportBean(Parcel in) {
        enterpriseName = in.readString();
        contacts = in.readString();
        phone = in.readString();
        userRegion = in.readString();
        crossRegion = in.readString();
        enterpriseSite = in.readString();
        photo = in.createStringArrayList();
        filenames = in.createTypedArrayList(UploadFileBean.CREATOR);
        remarks = in.readString();
        crossId = in.readString();
        status = in.readInt();
        rejectReason = in.readString();
        createTime = in.readString();
        updateTime = in.readString();
        readStatus = in.readInt();
    }

    public static final Creator<CrossShipmentReportBean> CREATOR = new Creator<CrossShipmentReportBean>() {
        @Override
        public CrossShipmentReportBean createFromParcel(Parcel in) {
            return new CrossShipmentReportBean(in);
        }

        @Override
        public CrossShipmentReportBean[] newArray(int size) {
            return new CrossShipmentReportBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(enterpriseName);
        parcel.writeString(contacts);
        parcel.writeString(phone);
        parcel.writeString(userRegion);
        parcel.writeString(crossRegion);
        parcel.writeString(enterpriseSite);
        parcel.writeStringList(photo);
        parcel.writeTypedList(filenames);
        parcel.writeString(remarks);
        parcel.writeString(crossId);
        parcel.writeInt(status);
        parcel.writeString(rejectReason);
        parcel.writeString(createTime);
        parcel.writeString(updateTime);
        parcel.writeInt(readStatus);
    }
}
