package com.tpy.jj.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel(value="登录类",description="请求参数类" )
public class Login implements Serializable {

    @NotEmpty(message = "不能为空")
    @Size(min = 5,max = 20,message = "账号不少于五位")
    @ApiModelProperty(value = "账号",example="tangpengyi")
    private String account;

    @NotEmpty(message = "不能为空")
    @Size(min = 6,max = 20,message = "密码不少于五位")
    @ApiModelProperty(value = "密码",example="123456")
    private String pwd;

}
