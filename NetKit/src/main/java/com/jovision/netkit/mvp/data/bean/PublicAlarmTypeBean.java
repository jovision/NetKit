package com.jovision.netkit.mvp.data.bean;

import java.util.List;

//本地录像类型
public class PublicAlarmTypeBean {

    private List<EventTypesBean> eventTypes;


    public List<EventTypesBean> getEventTypes() {
        return eventTypes;
    }

    public void setEventTypes(List<EventTypesBean> eventTypes) {
        this.eventTypes = eventTypes;
    }

    public static class EventTypesBean {

        private String alarmTypeCode;//录像类型编号
        private String alarmTypeName;//录像类型名称
        private boolean selected;

        public String getAlarmTypeCode() {
            return alarmTypeCode;
        }

        public void setAlarmTypeCode(String alarmTypeCode) {
            this.alarmTypeCode = alarmTypeCode;
        }

        public String getAlarmTypeName() {
            return alarmTypeName;
        }

        public void setAlarmTypeName(String alarmTypeName) {
            this.alarmTypeName = alarmTypeName;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }
    }
}
