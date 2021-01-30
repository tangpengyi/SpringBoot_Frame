package com.tpy.jj.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel(value="角色",description="请求参数类" )
public class Role {

    private int id;

    @ApiModelProperty(value = "姓名",example="张三")
    private int type_id;

    @NotEmpty(message = "不能为空")
    @ApiModelProperty(value = "角色名称",example="用户")
    private String role_name;

    @NotEmpty(message = "不能为空")
    @ApiModelProperty(value = "角色名称",example="user")
    private String role_value;

    private String create_user;

    private Date create_time;

    private String modify_user;

    private Date modify_time;

    private List<Permission> permissions;


}
