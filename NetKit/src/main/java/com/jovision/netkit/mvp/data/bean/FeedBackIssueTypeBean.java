package com.jovision.netkit.mvp.data.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Copyright@中维世纪
 *
 * @authore 彭强-24007
 * @time 2024-03-06 14:09
 * @description 意见反馈-反馈问题类型实体
 */
public class FeedBackIssueTypeBean implements Serializable {

    public FeedBackIssueTypeBean(){

    }

    private String type;
    private boolean openState = true;
    private List<DataEntity> twoTypes;

    public String getType() {
        return type;
    }

    public boolean isOpenState() {
        return openState;
    }

    public void setOpenState(boolean openState) {
        this.openState = openState;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<DataEntity> getTwoTypes() {
        return twoTypes;
    }

    public void setTwoTypes(List<DataEntity> twoTypes) {
        this.twoTypes = twoTypes;
    }

    public static class DataEntity implements Serializable{

        public DataEntity(String name,boolean check){
            this.twoTypeName = name;
            this.check = check;
        }

        public DataEntity(String id,String name,boolean check){

            this.twoTypeId = id;
            this.twoTypeName = name;
            this.check = check;
        }

        private String twoTypeId;
        private String twoTypeName;
        private boolean check;

        public String getTwoTypeId() {
            return twoTypeId;
        }

        public void setTwoTypeId(String twoTypeId) {
            this.twoTypeId = twoTypeId;
        }

        public String getTwoTypeName() {
            return twoTypeName;
        }

        public void setTwoTypeName(String twoTypeName) {
            this.twoTypeName = twoTypeName;
        }

        public boolean isCheck() {
            return check;
        }

        public void setCheck(boolean check) {
            this.check = check;
        }
    }
}
