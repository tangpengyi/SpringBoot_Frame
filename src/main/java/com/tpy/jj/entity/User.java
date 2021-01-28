package com.tpy.jj.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel(value="用户类",description="请求参数类" )
public class User implements Serializable {

    private int id;

    @NotEmpty(message = "不能为空")
    @ApiModelProperty(value = "姓名",example="张三")
    private String username;

    @Range(min = 0, max = 200, message = "不能为空")
    @ApiModelProperty(value = "年龄",example="23")
    private int age;

    @NotEmpty(message = "账号不能为空")
    @Size(min = 5,max = 20,message = "账号不能少于五位")
    @ApiModelProperty(value = "账号",example="tangpengyi")
    private String account;

    @NotEmpty(message = "密码不能为空")
    @Size(min = 6,max = 20,message = "密码不能少于六位")
    @ApiModelProperty(value = "密码",example="123456")
    private String pwd;

    // 随机盐
    @JsonIgnore
    private String salt;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date create_time;

    private String create_user;

}
