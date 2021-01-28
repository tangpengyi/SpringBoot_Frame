package com.tpy.jj.api;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseResult implements Serializable {

    private static volatile ResponseResult result = null;

    public static ResponseResult getBean(){
        if(ResponseResult.result == null){
            synchronized (ResponseResult.class) {
                if (result == null) {
                    result = new ResponseResult();
                }
            }
        }
        return result;
    }

    private int code;

    private String msg;

    private Object data;


}
