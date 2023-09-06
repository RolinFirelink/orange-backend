package com.orange.boot.dev5.controller;

import com.orange.boot.dev5.entity.User;
import com.orange.boot.dev5.service.AdministratorService;
import com.orange.boot.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author HY
 * @since 2022-09-12
 */

@RestController
@RequestMapping("/dev5")
@Api(tags = "管理员操作")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    // 用户权限修改功能
    @ApiOperation(value = "修改用户权限")
    @PostMapping("updatePermissions/{oldStatus}")
    public R updatePermissions(@RequestBody User user, @PathVariable Integer oldStatus){
        return administratorService.updatePermissions(user,oldStatus);
    }

    // 查询用户信息
    @ApiOperation(value = "查询用户信息")
    @GetMapping("getUser/{id}")
    public R getUser(@PathVariable String id){
        return administratorService.getUser(id);
    }

    // 逻辑删除用户
    @ApiOperation(value = "逻辑删除用户")
    @DeleteMapping("deleteUser/{id}")
    public R removeUser(@PathVariable String id){
        return administratorService.removeUser(id);
    }

    // 获取未通过审核的注册用户
    @ApiOperation(value = "获取未通过审核的注册用户")
    @PostMapping("getNotPassUser")
    public R getNotPassUser(){
        return administratorService.getNotPassUser();
    }

    // 管理员审核用户注册
    @ApiOperation(value = "管理员审核用户注册")
    @PostMapping("checkUser/{id}")
    public R checkUser(@PathVariable("id") String id){
        return administratorService.checkUser(id);
    }

}
