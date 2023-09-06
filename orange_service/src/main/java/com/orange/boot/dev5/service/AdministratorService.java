package com.orange.boot.dev5.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.orange.boot.dev5.entity.User;
import com.orange.boot.utils.R;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author HY
 * @since 2022-09-12
 */
@Service
public interface AdministratorService extends IService<User> {

    R updatePermissions(User user,Integer oldStatus);

    R getUser(String id);

    R removeUser(String id);

    R checkUser(String id);

    R getNotPassUser();
}
