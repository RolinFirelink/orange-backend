package com.orange.boot.dev1.controller;


import com.orange.boot.dev1.entity.DetailUrl;
import com.orange.boot.dev1.service.NewsService;
import com.orange.boot.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author CZF
 * @since 2022-05-26
 */
@RestController
@RequestMapping("/dev1/news")
@Api(tags = "动态资讯接口")
@CrossOrigin
public class NewsController {

    @Autowired
    NewsService newsService;

    @ApiOperation("写死的固定新闻")
    @GetMapping("{count}")
    public R getNews(@PathVariable("count") Integer count){
        return newsService.getNews(count);
    }

    @ApiOperation("爬虫爬取的新闻,最大页数9页， page取值1-9，表示1-9页")
    @GetMapping("paChong/{page}")
    public R paChong(@PathVariable("page") Integer page){
        return newsService.paChong(page);
    }

    @ApiOperation("爬虫爬取的新网站的新闻,最大页数9页， page取值1-9，表示1-9页")
    @GetMapping("newPaChong/{page}")
    public R newPaChong(@PathVariable("page") Integer page) throws IOException {
        System.out.println("爬虫方法被调用");
        try {
            return newsService.newPaChong(page);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @ApiOperation("根据详情页的url返回详情页信息")
    @PostMapping("detail")
    public R detail(@RequestBody DetailUrl detailUrl){
        return newsService.detail(detailUrl);
    }
}

