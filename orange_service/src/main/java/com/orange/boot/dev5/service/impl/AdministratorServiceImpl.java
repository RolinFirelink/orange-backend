package com.orange.boot.dev5.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orange.boot.dev5.entity.User;
import com.orange.boot.dev5.mapper.AdministratorMapper;
import com.orange.boot.dev5.service.AdministratorService;
import com.orange.boot.utils.R;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HY
 * @since 2022-09-12
 */
@Service
public class AdministratorServiceImpl extends ServiceImpl<AdministratorMapper, User> implements AdministratorService {

    @Override
    public R updatePermissions(User user,Integer oldStatus) {

        if (oldStatus == 2){
            return R.error().message("不可以修改管理员权限");
        }else {

            int i = baseMapper.updateById(user);
            if (i > 0) {
                return R.ok();
            }else {
                return R.error();
            }
        }

    }

    @Override
    public R getUser(String id) {
        User user = baseMapper.selectById(id);
        return R.ok().data("uesr",user);
    }

    @Override
    public R removeUser(String id) {
        int i = baseMapper.deleteById(id);

        if (i > 0) {
            return R.ok();
        }else {
            return R.error();
        }
    }

    @Override
    public R checkUser(String id) {
        User user = new User();
        user.setId(id);
        user.setPass(1);
        int i = baseMapper.updateById(user);
        if (i > 0){
            return R.ok();
        }else {
            return R.error();
        }
    }

    @Override
    public R getNotPassUser() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("pass", 0);
        List<User> users = baseMapper.selectList(wrapper);
        return R.ok().data("users", users);
    }

}
