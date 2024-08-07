package com.jovision.netkit.mvp.data.bean.response;

/**
 * 设备IP信息对象
 */
public class OctDevIPInfoBean {

    //        {	//获取网络接口列表
//        "method": "ifconfig_get_inet",
//            "level":"Operator",
//            "comments": "The value of quality ranges from 0 to 100.",
//            "param": {},
//        "result": {
//        "iface": "eth,ppp,wifi",
//                "eth": {
//            "name": "eth0",
//                    "bDHCP": true,						//自动获取ip使能
//                    "bAutoAdapt": true,					//自适应ip使能
//                    "bSmartOnline": true,               //智能上下线使能
//                    "bEnableOnline": true,				//允许上线
//                    "bIPLock": false,					//IP地址锁定使能
//                    "addr": "192.168.7.160",
//                    "mask": "255.255.255.0",
//                    "gateway": "192.168.7.1",
//                    "mac": "E0:62:90:33:58:C7",
//                    "dns": "202.102.128.68"
//        },
//        "ppp": {
//            "name": "adsl",
//                    "username": "qlc",
//                    "passwd": "123456"
//        },
//        "wifi": {
//            "name": "hehe",				//网卡名
//                    "ssid": "jovetech",			//wifi热点名
//                    "passwd": "111111",
//                    "quality": 100,						//信号质量:0~100
//                    "keystat": -1,
//                    "iestat": "open,shared,wep,wpa,wpa2,plain",
//                    "mode": "sta,ap",
//                    "bDHCP": true,
//                    "addr": "192.168.7.160",
//                    "mask": "255.255.255.0",
//                    "gateway": "192.168.7.1",
//                    "mac": "E0:62:90:33:58:C7",
//                    "dns": "202.102.128.68"
//        },
//        "ddns": {
//            "server": "Dyndns DDNS",
//                    "domain": "www.jovision.com",
//                    "user": "admin",
//                    "passwd": "123456"
//        },
//        "_4G": {
//            "iccid": "8986032046208250378", 		// 4G模块的iccid
//                    "mode": "4G",
//                    "quality": -90
//        }
//    },
//        "error": {
//        "errorcode": -1,
//                "message": "Failed to get network configuration!"
//    }
//    }

    private String method;
    private String level;
    private String comments;
    private ParamBean param;
    private ResultBean result;
    private ErrorBean error;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public ParamBean getParam() {
        return param;
    }

    public void setParam(ParamBean param) {
        this.param = param;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public ErrorBean getError() {
        return error;
    }

    public void setError(ErrorBean error) {
        this.error = error;
    }

    public static class ParamBean {
    }

    public static class ResultBean {
        private String iface;
        private EthBean eth;
        private PppBean ppp;
        private WifiBean wifi;
        private DdnsBean ddns;
        private _$4GBean _4G;

        public String getIface() {
            return iface;
        }

        public void setIface(String iface) {
            this.iface = iface;
        }

        public EthBean getEth() {
            return eth;
        }

        public void setEth(EthBean eth) {
            this.eth = eth;
        }

        public PppBean getPpp() {
            return ppp;
        }

        public void setPpp(PppBean ppp) {
            this.ppp = ppp;
        }

        public WifiBean getWifi() {
            return wifi;
        }

        public void setWifi(WifiBean wifi) {
            this.wifi = wifi;
        }

        public DdnsBean getDdns() {
            return ddns;
        }

        public void setDdns(DdnsBean ddns) {
            this.ddns = ddns;
        }

        public _$4GBean get_4G() {
            return _4G;
        }

        public void set_4G(_$4GBean _4G) {
            this._4G = _4G;
        }

        public static class EthBean {
            private String name;
            private boolean bDHCP;
            private boolean bAutoAdapt;
            private boolean bSmartOnline;
            private boolean bEnableOnline;
            private boolean bIPLock;
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

            public boolean isBDHCP() {
                return bDHCP;
            }

            public void setBDHCP(boolean bDHCP) {
                this.bDHCP = bDHCP;
            }

            public boolean isBAutoAdapt() {
                return bAutoAdapt;
            }

            public void setBAutoAdapt(boolean bAutoAdapt) {
                this.bAutoAdapt = bAutoAdapt;
            }

            public boolean isBSmartOnline() {
                return bSmartOnline;
            }

            public void setBSmartOnline(boolean bSmartOnline) {
                this.bSmartOnline = bSmartOnline;
            }

            public boolean isBEnableOnline() {
                return bEnableOnline;
            }

            public void setBEnableOnline(boolean bEnableOnline) {
                this.bEnableOnline = bEnableOnline;
            }

            public boolean isBIPLock() {
                return bIPLock;
            }

            public void setBIPLock(boolean bIPLock) {
                this.bIPLock = bIPLock;
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

        public static class PppBean {
            private String name;
            private String username;
            private String passwd;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getPasswd() {
                return passwd;
            }

            public void setPasswd(String passwd) {
                this.passwd = passwd;
            }
        }

        public static class WifiBean {
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

            public boolean isBDHCP() {
                return bDHCP;
            }

            public void setBDHCP(boolean bDHCP) {
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

        public static class DdnsBean {
            private String server;
            private String domain;
            private String user;
            private String passwd;

            public String getServer() {
                return server;
            }

            public void setServer(String server) {
                this.server = server;
            }

            public String getDomain() {
                return domain;
            }

            public void setDomain(String domain) {
                this.domain = domain;
            }

            public String getUser() {
                return user;
            }

            public void setUser(String user) {
                this.user = user;
            }

            public String getPasswd() {
                return passwd;
            }

            public void setPasswd(String passwd) {
                this.passwd = passwd;
            }
        }

        public static class _$4GBean {
            private String iccid;
            private String mode;
            private int quality;

            public String getIccid() {
                return iccid;
            }

            public void setIccid(String iccid) {
                this.iccid = iccid;
            }

            public String getMode() {
                return mode;
            }

            public void setMode(String mode) {
                this.mode = mode;
            }

            public int getQuality() {
                return quality;
            }

            public void setQuality(int quality) {
                this.quality = quality;
            }
        }
    }

    public static class ErrorBean {
        private int errorcode;
        private String message;

        public int getErrorcode() {
            return errorcode;
        }

        public void setErrorcode(int errorcode) {
            this.errorcode = errorcode;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }






//    private String method;
//    private String comments;
//    private UserBean user;
//    private ResultBean result;
//    private ErrorBean error;
//
//    public String getComments() {
//        return comments;
//    }
//
//    public void setComments(String comments) {
//        this.comments = comments;
//    }
//
//    public String getMethod() {
//        return method;
//    }
//
//    public void setMethod(String method) {
//        this.method = method;
//    }
//
//    public UserBean getUser() {
//        return user;
//    }
//
//    public void setUser(UserBean user) {
//        this.user = user;
//    }
//
//    public ResultBean getResult() {
//        return result;
//    }
//
//    public void setResult(ResultBean result) {
//        this.result = result;
//    }
//
//    public ErrorBean getError() {
//        return error;
//    }
//
//    public void setError(ErrorBean error) {
//        this.error = error;
//    }
//
//    public static class UserBean {
//        /**
//         * digest : dc23fc88256c7c561d1357cceac72b92
//         * name : admin
//         */
//
//        private String digest;
//        private String name;
//
//        public String getDigest() {
//            return digest;
//        }
//
//        public void setDigest(String digest) {
//            this.digest = digest;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//    }
//
//    public static class ResultBean {
//
//
//        private String iface;
//        private EthBean eth;
//        private PppBean ppp;
//        private WifiBean wifi;
//        private DdnsBean ddns;
//
//        public String getIface() {
//            return iface;
//        }
//
//        public void setIface(String iface) {
//            this.iface = iface;
//        }
//
//        public EthBean getEth() {
//            return eth;
//        }
//
//        public void setEth(EthBean eth) {
//            this.eth = eth;
//        }
//
//        public PppBean getPpp() {
//            return ppp;
//        }
//
//        public void setPpp(PppBean ppp) {
//            this.ppp = ppp;
//        }
//
//        public WifiBean getWifi() {
//            return wifi;
//        }
//
//        public void setWifi(WifiBean wifi) {
//            this.wifi = wifi;
//        }
//
//        public DdnsBean getDdns() {
//            return ddns;
//        }
//
//        public void setDdns(DdnsBean ddns) {
//            this.ddns = ddns;
//        }
//
//        public static class EthBean{
//            private String name;
//            private boolean bDHCP;
//            private boolean bAutoAdapt;
//            private boolean bSmartOnline;
//            private boolean bEnableOnline;
//            private boolean bIPLock;
//            private String addr;
//            private String mask;
//            private String gateway;
//            private String mac;
//            private String dns;
//
//            public String getName() {
//                return name;
//            }
//
//            public void setName(String name) {
//                this.name = name;
//            }
//
//            public boolean isbDHCP() {
//                return bDHCP;
//            }
//
//            public void setbDHCP(boolean bDHCP) {
//                this.bDHCP = bDHCP;
//            }
//
//            public boolean isbAutoAdapt() {
//                return bAutoAdapt;
//            }
//
//            public void setbAutoAdapt(boolean bAutoAdapt) {
//                this.bAutoAdapt = bAutoAdapt;
//            }
//
//            public boolean isbSmartOnline() {
//                return bSmartOnline;
//            }
//
//            public void setbSmartOnline(boolean bSmartOnline) {
//                this.bSmartOnline = bSmartOnline;
//            }
//
//            public boolean isbEnableOnline() {
//                return bEnableOnline;
//            }
//
//            public void setbEnableOnline(boolean bEnableOnline) {
//                this.bEnableOnline = bEnableOnline;
//            }
//
//            public boolean isbIPLock() {
//                return bIPLock;
//            }
//
//            public void setbIPLock(boolean bIPLock) {
//                this.bIPLock = bIPLock;
//            }
//
//            public String getAddr() {
//                return addr;
//            }
//
//            public void setAddr(String addr) {
//                this.addr = addr;
//            }
//
//            public String getMask() {
//                return mask;
//            }
//
//            public void setMask(String mask) {
//                this.mask = mask;
//            }
//
//            public String getGateway() {
//                return gateway;
//            }
//
//            public void setGateway(String gateway) {
//                this.gateway = gateway;
//            }
//
//            public String getMac() {
//                return mac;
//            }
//
//            public void setMac(String mac) {
//                this.mac = mac;
//            }
//
//            public String getDns() {
//                return dns;
//            }
//
//            public void setDns(String dns) {
//                this.dns = dns;
//            }
//        }
//        public static class PppBean{
//            private String name;
//            private String username;
//            private String passwd;
//
//            public String getName() {
//                return name;
//            }
//
//            public void setName(String name) {
//                this.name = name;
//            }
//
//            public String getUsername() {
//                return username;
//            }
//
//            public void setUsername(String username) {
//                this.username = username;
//            }
//
//            public String getPasswd() {
//                return passwd;
//            }
//
//            public void setPasswd(String passwd) {
//                this.passwd = passwd;
//            }
//        }
//        public static class WifiBean{
//
//            private String name;
//            private String ssid;
//            private String passwd;
//            private int quality;
//            private int keystat;
//            private String iestat;
//            private boolean bDHCP;
//            private String addr;
//            private String mask;
//            private String gateway;
//            private String mac;
//            private String dns;
//
//            public String getName() {
//                return name;
//            }
//
//            public void setName(String name) {
//                this.name = name;
//            }
//
//            public String getSsid() {
//                return ssid;
//            }
//
//            public void setSsid(String ssid) {
//                this.ssid = ssid;
//            }
//
//            public String getPasswd() {
//                return passwd;
//            }
//
//            public void setPasswd(String passwd) {
//                this.passwd = passwd;
//            }
//
//            public int getQuality() {
//                return quality;
//            }
//
//            public void setQuality(int quality) {
//                this.quality = quality;
//            }
//
//            public int getKeystat() {
//                return keystat;
//            }
//
//            public void setKeystat(int keystat) {
//                this.keystat = keystat;
//            }
//
//            public String getIestat() {
//                return iestat;
//            }
//
//            public void setIestat(String iestat) {
//                this.iestat = iestat;
//            }
//
//            public boolean isbDHCP() {
//                return bDHCP;
//            }
//
//            public void setbDHCP(boolean bDHCP) {
//                this.bDHCP = bDHCP;
//            }
//
//            public String getAddr() {
//                return addr;
//            }
//
//            public void setAddr(String addr) {
//                this.addr = addr;
//            }
//
//            public String getMask() {
//                return mask;
//            }
//
//            public void setMask(String mask) {
//                this.mask = mask;
//            }
//
//            public String getGateway() {
//                return gateway;
//            }
//
//            public void setGateway(String gateway) {
//                this.gateway = gateway;
//            }
//
//            public String getMac() {
//                return mac;
//            }
//
//            public void setMac(String mac) {
//                this.mac = mac;
//            }
//
//            public String getDns() {
//                return dns;
//            }
//
//            public void setDns(String dns) {
//                this.dns = dns;
//            }
//        }
//        public static class DdnsBean{
//            private String server;
//            private String domain;
//            private String user;
//            private String passwd;
//
//            public String getServer() {
//                return server;
//            }
//
//            public void setServer(String server) {
//                this.server = server;
//            }
//
//            public String getDomain() {
//                return domain;
//            }
//
//            public void setDomain(String domain) {
//                this.domain = domain;
//            }
//
//            public String getUser() {
//                return user;
//            }
//
//            public void setUser(String user) {
//                this.user = user;
//            }
//
//            public String getPasswd() {
//                return passwd;
//            }
//
//            public void setPasswd(String passwd) {
//                this.passwd = passwd;
//            }
//        }
//    }
//
//    public static class ErrorBean {
//        /**
//         * errorcode : 0
//         */
//
//        private int errorcode;
//
//        public int getErrorcode() {
//            return errorcode;
//        }
//
//        public void setErrorcode(int errorcode) {
//            this.errorcode = errorcode;
//        }
//    }
//
////    {	//获取网络接口列表
////        "method": "ifconfig_get_inet",
////            "comments": "The value of quality ranges from 0 to 100.",
////            "param": {},
////        "result": {
////        "iface": "eth,ppp,wifi",
////                "eth": {
////            "name": "eth0",
////                    "bDHCP": true,						//自动获取ip使能
////                    "bAutoAdapt": true,					//自适应ip使能
////                    "bSmartOnline": true,               //智能上下线使能
////                    "bEnableOnline": true,				//允许上线
////                    "bIPLock": false,					//IP地址锁定使能
////                    "addr": "192.168.7.160",
////                    "mask": "255.255.255.0",
////                    "gateway": "192.168.7.1",
////                    "mac": "E0:62:90:33:58:C7",
////                    "dns": "202.102.128.68"
////        },
////        "ppp": {
////            "name": "adsl",
////                    "username": "qlc",
////                    "passwd": "123456"
////        },
////        "wifi": {
////            "name": "hehe",				//网卡名
////                    "ssid": "jovetech",			//wifi热点名
////                    "passwd": "111111",
////                    "quality": 100,						//信号质量:0~100
////                    "keystat": -1,
////                    "iestat": "open,shared,wep,wpa,wpa2,plain",
////                    "mode": "sta,ap",
////                    "bDHCP": true,
////                    "addr": "192.168.7.160",
////                    "mask": "255.255.255.0",
////                    "gateway": "192.168.7.1",
////                    "mac": "E0:62:90:33:58:C7",
////                    "dns": "202.102.128.68"
////        },
////        "ddns": {
////            "server": "Dyndns DDNS",
////                    "domain": "www.jovision.com",
////                    "user": "admin",
////                    "passwd": "123456"
////        }
////    },
////        "error": {
////        "errorcode": -1,
////                "message": "Failed to get network configuration!"
////    }
////    },

}
