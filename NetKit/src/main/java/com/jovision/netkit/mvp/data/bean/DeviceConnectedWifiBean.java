package com.jovision.netkit.mvp.data.bean;

public class DeviceConnectedWifiBean {
    private String name;
    private String ssid;
    private String passwd;
    private int quality;
    private int keystat;
    private String iestat;
    private String mode;
    private boolean bDHCP;
    private String addr;
    private String mask;
    private String gateway;
    private String mac;
    private String dns;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getKeystat() {
        return keystat;
    }

    public void setKeystat(int keystat) {
        this.keystat = keystat;
    }

    public String getIestat() {
        return iestat;
    }

    public void setIestat(String iestat) {
        this.iestat = iestat;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public boolean isbDHCP() {
        return bDHCP;
    }

    public void setbDHCP(boolean bDHCP) {
        this.bDHCP = bDHCP;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getDns() {
        return dns;
    }

    public void setDns(String dns) {
        this.dns = dns;
    }
}
