package com.jovision.netkit.mvp.data.http;

/**
 * 播放地址，自组播放链接，云视通1.0和2.0
 */
public class ConnectUrlBean {
    private String sn;
    private String ip;
    private int port;
    private String user;
    private String password;
    private String protocol;
    private int channel_count;
    private int code;
    private String token;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public int getChannel_count() {
        return channel_count;
    }

    public void setChannel_count(int channel_count) {
        this.channel_count = channel_count;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
