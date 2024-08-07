package com.jovision.netkit.mvp.data.bean.response;


import java.util.List;

//云台能力级
public class OctPtzAbilityBean {





//    {	//获取PTZ能力
//        "method": "ptz_ability_get",
//            "level":"Operator",
//            "param": {
//        "channelid": 0	//通道号，从0开始。
//    },
//        "result": {
//        "motor_ability": "none,pan_tilt_both,pan_tilt_mutex", //电机控制能力集 none不支持,pan_tilt_both水平垂直同时转动,pan_tilt_mutex水平垂直互斥转动
//                "lens_ability": ["zoom,focus,iris"], //镜头控制能力集 zoom变倍  focus变焦  iris光圈
//        "ex_ability" : ["calibrate, auto_move"], // 扩展功能， calibrate 云台校准 auto_move 自动旋转(上下左右中间的那个按键)
//        "max_preset": 255,  //最大预置点个数
//                "max_patrol": 2,    //最大巡航条数
//                "max_trail": 4,		//最大轨迹条数
//                "max_task": 2       //最大定时任务个数
//    },
//             "error":{
//        "errorcode":0,
//                "message":"Invalid Params"
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
        private int channelid;

        public int getChannelid() {
            return channelid;
        }

        public void setChannelid(int channelid) {
            this.channelid = channelid;
        }
    }

    public static class ResultBean {
        private String motor_ability;//"none,pan_tilt_both,pan_tilt_mutex", //电机控制能力集 none不支持,pan_tilt_both水平垂直同时转动,pan_tilt_mutex水平垂直互斥转动
        private List<String> lens_ability;//["zoom,focus,iris"], //镜头控制能力集 zoom变倍  focus变焦  iris光圈
        private List<String> ex_ability;//["calibrate, auto_move"], // 扩展功能， calibrate 云台校准 auto_move 自动旋转(上下左右中间的那个按键)
        private int max_preset;
        private int max_patrol;
        private int max_trail;
        private int max_task;


        //获取云台镜头zoom变倍能力及
        public boolean getAbilityZoom(){
            return getLensAbility("zoom");
        }

        //获取云台镜头focus变焦能力及
        public boolean getAbilityFocus(){
            return getLensAbility("focus");
        }

        //获取自动旋转能力及
        public boolean getAbilityAutoMove(){
            return getLensAbility("auto_move");
        }




        //获取云台校准能力及
        public boolean getAbilityCalibrate(){
            return getExAbility("calibrate");
        }


        //云台跟踪初始位置
        public boolean getAbilityTraceGuard(){
            return getExAbility("trace_guard");
        }



        public boolean getExAbility(String key){
            boolean contains = false;

            if(null != ex_ability && ex_ability.size() > 0){

                for(int i = 0 ; i < ex_ability.size() ;i++){
                    if(ex_ability.get(i).equalsIgnoreCase(key)){
                        contains = true;
                        break;
                    }
                }
            }

            return contains;
        }


        public boolean getLensAbility(String key){
            boolean contains = false;

            if(null != lens_ability && lens_ability.size() > 0){

                for(int i = 0 ; i < lens_ability.size() ;i++){

                    if(lens_ability.get(i).equalsIgnoreCase(key)){
                        contains = true;
                        break;
                    }
                }
            }

            return contains;
        }

        public String getMotor_ability() {
            return motor_ability;
        }

        public void setMotor_ability(String motor_ability) {
            this.motor_ability = motor_ability;
        }

        public List<String> getLens_ability() {
            return lens_ability;
        }

        public void setLens_ability(List<String> lens_ability) {
            this.lens_ability = lens_ability;
        }

        public List<String> getEx_ability() {
            return ex_ability;
        }

        public void setEx_ability(List<String> ex_ability) {
            this.ex_ability = ex_ability;
        }

        public int getMax_preset() {
            return max_preset;
        }

        public void setMax_preset(int max_preset) {
            this.max_preset = max_preset;
        }

        public int getMax_patrol() {
            return max_patrol;
        }

        public void setMax_patrol(int max_patrol) {
            this.max_patrol = max_patrol;
        }

        public int getMax_trail() {
            return max_trail;
        }

        public void setMax_trail(int max_trail) {
            this.max_trail = max_trail;
        }

        public int getMax_task() {
            return max_task;
        }

        public void setMax_task(int max_task) {
            this.max_task = max_task;
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







//    private ResultBean result;
//    private ErrorBean error;
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
//    public class ResultBean{
//
//        private boolean calibrate_support;//是否支持云台校准
//        private int max_preset;//最大预置点个数
//        private int max_patrol;//最大巡航条数
//        private int max_trail;//最大轨迹条数
//        private int max_task;//最大定时任务个数
//
//
//        public int getMax_preset() {
//            return max_preset;
//        }
//
//        public void setMax_preset(int max_preset) {
//            this.max_preset = max_preset;
//        }
//
//        public int getMax_patrol() {
//            return max_patrol;
//        }
//
//        public void setMax_patrol(int max_patrol) {
//            this.max_patrol = max_patrol;
//        }
//
//        public int getMax_trail() {
//            return max_trail;
//        }
//
//        public void setMax_trail(int max_trail) {
//            this.max_trail = max_trail;
//        }
//
//        public int getMax_task() {
//            return max_task;
//        }
//
//        public void setMax_task(int max_task) {
//            this.max_task = max_task;
//        }
//
//        public boolean isCalibrate_support() {
//            return calibrate_support;
//        }
//
//        public void setCalibrate_support(boolean calibrate_support) {
//            this.calibrate_support = calibrate_support;
//        }
//    }


}
