package com.orange.boot.dev1.controller;

import com.orange.boot.dev1.entity.User;
import com.orange.boot.dev1.entity.UserVo;
import com.orange.boot.dev1.service.UserService;
import com.orange.boot.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author CZF
 * @create 2022-05-25 0:45
 */

@RestController("webUserController")
@CrossOrigin
@RequestMapping("/web/user")
@Slf4j
@Api(tags = "web用户接口")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation("登录")
    @PostMapping("login")
    public R login(@RequestBody UserVo userVo){

        return userService.login(userVo);
    }

    @ApiOperation("注册")
    @PostMapping("register")
    public R register(@RequestBody User user){
        return userService.register(user);
    }
}
