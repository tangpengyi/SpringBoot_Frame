package com.tpy.jj.utils;

public enum StatusCodeConstant {

    CODE_200(200),
    // not foound
    CODE_404(404),
    // 未授权
    CODE_401(401 ),
    // 服务无法解析
    CODE_400(400),
    // 禁止访问
    CODE_403(403),
    // 服务错误
    CODE_500(500);

    public int value;

    private StatusCodeConstant(int value){
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
