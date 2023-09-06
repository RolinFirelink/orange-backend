package com.orange.boot.environment.controller;

import com.orange.boot.environment.entity.EnvironmentData;
import com.orange.boot.environment.service.EnvironmentDataService;
import com.orange.boot.utils.R;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Lin
 * @Date: 2022/9/13/10:57
 * @Description:
 */
@Api("环境参数")
@RestController
@RequestMapping("/environment")
public class EnvironmentDataController {

    EnvironmentDataService service;

    public EnvironmentDataController(EnvironmentDataService service) {
        this.service = service;
    }

    @GetMapping("/getDate/{code}")
    public R getData(@PathVariable String code) {
        List<EnvironmentData> environmentData = service.getEnvironmentData(code);
        return environmentData.size() != 0 ? R.ok().data("data", environmentData) : R.error("获取数据失败");
    }
}
