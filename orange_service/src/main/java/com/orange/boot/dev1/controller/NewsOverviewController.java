package com.orange.boot.dev1.controller;

import com.orange.boot.dev1.service.NewsOverviewService;
import com.orange.boot.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author Rolin
 */
@RestController
@RequestMapping("/dev1/crawler")
@Api(tags = "惠农网爬虫")
public class NewsOverviewController {

    @Autowired
    private NewsOverviewService newsOverviewService;

    @ApiOperation("定时爬取网站内容并存入数据库")
    @PostMapping("timing")
    public R crawler(){
        System.out.println("爬虫方法被调用");
        try {
            newsOverviewService.timingCraw();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return R.ok();
    }
}
