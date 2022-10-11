package com.lin.xiaoyaoshai.config;

public class CodeMsg {

    private int code;
    private String msg;

    //通用的错误码
    public static CodeMsg NO_FOUND = new CodeMsg(400, "404");
    public static CodeMsg SUCCESS = new CodeMsg(0, "success");
    public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务端异常");
    public static CodeMsg BIND_ERROR = new CodeMsg(500101, "参数校验异常：%s");
    public static CodeMsg ACCESS_LIMIT_REACHED= new CodeMsg(500104, "访问高峰期，请稍等！");
    //用户模块 5002XX
    public static CodeMsg LOGIN_FAIL = new CodeMsg(500210, "登陆失败");
    public static CodeMsg SEND_CODE_FAIL = new CodeMsg(500211, "发送失败");
    public static CodeMsg REGISTER_FAIL = new CodeMsg(500212, "注册失败");
    public static CodeMsg MATCH_WAIT = new CodeMsg(500215, "正在匹配");
    public static CodeMsg DIS_ERROR = new CodeMsg(500216, "解除关系失败");

    //订单模块 5003XX
    public static CodeMsg ORDER_EMPTY = new CodeMsg(500310, "无订单");


    //预约单模块 5004XX
    public static CodeMsg IMG_NOT_RIGHT = new CodeMsg(500400, "上传图片格式不合法");
    public static CodeMsg IMG_UPLOAD_FALSE = new CodeMsg(500401, "上传图片失败");

    //秒杀模块 5005XX
    public static CodeMsg SECKILL_OVER = new CodeMsg(500500, "商品已经秒杀完毕");
    public static CodeMsg REPEATE_SECKILL = new CodeMsg(500501, "不能重复秒杀");

    private CodeMsg() {
    }

    private CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 返回带参数的错误码
     * @param args
     * @return
     */
    public CodeMsg fillArgs(Object... args) {
        int code = this.code;
        String message = String.format(this.msg, args);
        return new CodeMsg(code, message);
    }

    @Override
    public String toString() {
        return "CodeMsg [code=" + code + ", msg=" + msg + "]";
    }


}
