package com.orange.boot.dev1.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orange.boot.dev1.entity.User;
import com.orange.boot.dev1.entity.UserVo;
import com.orange.boot.dev1.mapper.UserMapper;
import com.orange.boot.dev1.service.UserService;
import com.orange.boot.utils.MD5;
import com.orange.boot.utils.R;
import com.orange.boot.utils.ResultCode;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CZF
 * @since 2022-05-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    public R login(UserVo userVo) {

        User userFromDB = baseMapper.selectOne(new QueryWrapper<User>()
                .eq("username", userVo.getUsername())
                .eq("password",MD5.encrypt(userVo.getPassword())));
        if(userFromDB==null){
            return R.error().message("用户名或密码错误");
        }
        return R.ok().data("user", userFromDB);
    }

    @Override
    public R register(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.eq("username", user.getUsername());
        User user1 = baseMapper.selectOne(wrapper);
        if (user1 != null) {
            return R.error().code(ResultCode.ALREADY_EXISTS).message("该账号已被注册！");
        }
        user.setPassword(MD5.encrypt(user.getPassword()));
        baseMapper.insert(user);
        return R.ok();
    }
}
