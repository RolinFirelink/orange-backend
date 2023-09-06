package com.orange.boot.environment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.orange.boot.environment.entity.EnvironmentData;

import java.util.List;

/**
 * @Author: Lin
 * @Date: 2022/9/9/14:33
 * @Description:
 */

public interface EnvironmentDataService extends IService<EnvironmentData> {
    List<EnvironmentData> getEnvironmentData(String code);
}
