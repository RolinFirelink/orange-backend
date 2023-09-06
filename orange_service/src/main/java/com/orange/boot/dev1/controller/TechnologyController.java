package com.orange.boot.dev1.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.orange.boot.dev1.entity.*;
import com.orange.boot.dev1.service.NewsDetailsService;
import com.orange.boot.dev1.service.NewsOverviewService;
import com.orange.boot.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author CZF
 * @create 2022-06-08 22:56
 */
@RestController
@RequestMapping("/dev1/technology")
@Api(tags = "种植技术")
@CrossOrigin
public class TechnologyController {

    @Autowired
    private NewsOverviewService overviewService;

    @Autowired
    private NewsDetailsService detailsService;

    @GetMapping("list")
    public R list(){
        List<NewsOverview> list = overviewService.list();
        List<TechnologyItem> items = list.stream().map((item)->{
            TechnologyItem technology = new TechnologyItem();
            technology.setTitle(item.getTitle());
            technology.setPicUrl(item.getImage());
            technology.setDetailUrl(item.getDetailUrl());
            return technology;
        }).collect(Collectors.toList());
        return R.ok().data("items",items);
    }

    @ApiOperation("根据详情页的url返回详情页信息")
    @PostMapping("detail")
    public R detail(@RequestBody DetailUrl detailUrl) {
        String url = detailUrl.getDetailUrl();
        List<NewsDetails> list = detailsService.list();
        NewsDetails target = null;
        for (NewsDetails newsDetails : list) {
            if(newsDetails.getUrl().equals(url)){
                target=newsDetails;
                break;
            }
        }
        if(target==null){
            return R.error("没有对应网址的爬虫信息");
        }
        return R.ok().data("detailHtml",target.getText());
    }
}
