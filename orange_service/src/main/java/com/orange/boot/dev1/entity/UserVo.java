package com.orange.boot.dev1.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author CZF
 * @create 2022-05-25 0:48
 */
@Data
@ApiModel("web登录的用户名密码")
public class UserVo implements Serializable {

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;
}
