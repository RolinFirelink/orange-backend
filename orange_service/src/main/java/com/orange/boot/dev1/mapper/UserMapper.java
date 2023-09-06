package com.orange.boot.dev1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.orange.boot.dev1.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CZF
 * @since 2022-05-25
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
