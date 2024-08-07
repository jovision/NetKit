package com.jovision.netkit.mvp.data.bean.response;

public class OctAccountModifyUserBean {


    //    {
//        "method": "account_modify_user",
//            "level":"Administrator",
//            "param":
//        {
//            "name": "username",
//                "old_passwd": "123456",
//                "passwd": "123456",
//                "level": "admin,operator,user,anonymous,extended",
//                "description": "This is Adiministrator"
//        },
//        "result": {},
//                    "error": {
//        "errorcode": 0,
//        "message": "Invalid Params"
//    }
//    }


    private String method;
    private String level;
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
        private String name;
        private String old_passwd;
        private String passwd;
        private String level;
        private String description;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOld_passwd() {
            return old_passwd;
        }

        public void setOld_passwd(String old_passwd) {
            this.old_passwd = old_passwd;
        }

        public String getPasswd() {
            return passwd;
        }

        public void setPasswd(String passwd) {
            this.passwd = passwd;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    public static class ResultBean {
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


}
