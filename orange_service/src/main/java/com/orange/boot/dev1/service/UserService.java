package com.orange.boot.dev1.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.orange.boot.dev1.entity.User;
import com.orange.boot.dev1.entity.UserVo;
import com.orange.boot.utils.R;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CZF
 * @since 2022-05-25
 */
public interface UserService extends IService<User> {

    R login(UserVo userVo);

    R register(User user);
}
