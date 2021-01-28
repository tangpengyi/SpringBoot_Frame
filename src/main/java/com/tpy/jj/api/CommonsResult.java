package com.tpy.jj.api;

public class CommonsResult {

    private static ResponseResult result = ResponseResult.getBean();

    public static ResponseResult success(Object data){
        return success("操作成功",data);
    }
    public static ResponseResult success(String msg, Object data){
        result.setCode(200);
        result.setData(data);
        result.setMsg(msg);
        return result;
    }

    public static ResponseResult fail(String msg){
        return fail(404,msg);
    }
    public static ResponseResult fail(int code, String msg){
        result.setCode(code);
        result.setData(null);
        result.setMsg(msg);
        return result;
    }

}
