package com.tpy.jj.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel(value="权限",description="请求参数类" )
public class Permission {

    private int id;

    @NotEmpty(message = "不能为空")
    @ApiModelProperty(value = "权限名称",example="用户删除")
    private String permission_name;

    @NotEmpty(message = "不能为空")
    @ApiModelProperty(value = "权限类型",example="用户管理")
    private String permission_type;

    @NotEmpty(message = "不能为空")
    @ApiModelProperty(value = "权限类型",example="用户管理")
    private String permission_value;

    private String create_user;

    private Date create_time;

    private String modify_user;

    private String modify_time;

}


