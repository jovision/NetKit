package com.jovision.netkit.mvp.data.bean;

public class WeatherBean {
    private int temperature;//	温度（℃）
    private int feelsTemperature;//	体感温度(℃)
    private int relativeHumidity;//	相对湿度(%)
    private String windClass;//	风力等级
    private String windDirection;//	风向描述
    private String weatherText;//	天气现象
    private String updateTime;//	数据更新时间（格式：RFC3339）

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getFeelsTemperature() {
        return feelsTemperature;
    }

    public void setFeelsTemperature(int feelsTemperature) {
        this.feelsTemperature = feelsTemperature;
    }

    public int getRelativeHumidity() {
        return relativeHumidity;
    }

    public void setRelativeHumidity(int relativeHumidity) {
        this.relativeHumidity = relativeHumidity;
    }

    public String getWindClass() {
        return windClass;
    }

    public void setWindClass(String windClass) {
        this.windClass = windClass;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getWeatherText() {
        return weatherText;
    }

    public void setWeatherText(String weatherText) {
        this.weatherText = weatherText;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
