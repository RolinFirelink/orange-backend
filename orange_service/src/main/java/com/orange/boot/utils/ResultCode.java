package com.orange.boot.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("返回码")
public interface ResultCode {

    @ApiModelProperty("0: 成功")
    public static Integer SUCCESS = 0;//成功

    @ApiModelProperty("1: 失败")
    public static Integer ERROR = 1;//失败

    @ApiModelProperty("2: 资源用户不存在")
    public static Integer NOT_FOUND = 2;//资源用户不存在

    @ApiModelProperty("3: 用户名不存在")
    public static Integer NOT_REGISTER = 3;//用户名不存在

    @ApiModelProperty("4: 密码错误")
    public static Integer WRONG = 4;//密码错误

    @ApiModelProperty("5: 该账号已被注册")
    public static Integer ALREADY_EXISTS = 5;//该账号已被注册

    @ApiModelProperty("6: 该账号已被注册")
    public static Integer BEYOND_PAGES = 6;//该账号已被注册


}
