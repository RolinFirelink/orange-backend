package com.orange.boot.environment.controller;

import com.orange.boot.environment.entity.EnvironmentData;
import com.orange.boot.environment.service.EnvironmentDataService;
import com.orange.boot.environment.util.MapToEnvironmentDataConverter;
import com.orange.boot.utils.R;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @Author: Lin
 * @Date: 2022/9/8/21:22
 * @Description:
 */
@RestController
@RequestMapping("/orange_service/environment")
@Api(tags = "订阅设备数据回调接口")
public class EnvironmentCallbackController {

    EnvironmentDataService service;
//    @PostMapping("/callback")
//    public void callback(@RequestBody Map map) {
//        System.out.println(JSON.toJSONString(map));
//    }

    @PostMapping("/callback")
    public R callback(@RequestBody Map map) {
        String code =(String) map.get("code");
        if ("debug".equals(code)) {
            return R.error("测试模式不接收数据");
        }
        List<HashMap> data = (ArrayList<HashMap>) map.get("data");
        if (data == null) {
            throw new RuntimeException("数据为空");
        }
        EnvironmentData[] environmentData = MapToEnvironmentDataConverter.MapToEnvironmentData(data);
        service.saveBatch(Arrays.asList(environmentData));
        return R.ok();
    }

    public EnvironmentCallbackController(EnvironmentDataService service) {
        this.service = service;
    }
}

