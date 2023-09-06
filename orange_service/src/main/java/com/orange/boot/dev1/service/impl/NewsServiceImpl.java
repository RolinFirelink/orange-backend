package com.orange.boot.dev1.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orange.boot.dev1.entity.DetailUrl;
import com.orange.boot.dev1.entity.News;
import com.orange.boot.dev1.entity.PaChongNew;
import com.orange.boot.dev1.mapper.NewsMapper;
import com.orange.boot.dev1.service.NewsService;
import com.orange.boot.utils.R;
import com.orange.boot.utils.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.bcel.generic.TABLESWITCH;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author CZF
 * @since 2022-05-26
 */
@Service
@Slf4j
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {

    @Override
    public R getNews(int count) {
        List<News> news = baseMapper.selectList(new QueryWrapper<News>()
                .orderByDesc("gmt_create")
                .last("limit " + count));
        return R.ok().data("news", news);
    }

    @Override
    public R paChong(Integer page) {

        if (page > 9) {
            return R.error().code(ResultCode.BEYOND_PAGES).message("超过总页数！");
        }

        List<PaChongNew> list = new ArrayList<>();

        String url = "http://www.ganjuren.com/jishu/bchgl/p10" + page.toString() + ".html";

        Document document = null;
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
            return R.error().message("爬取信息失败！");
        }

        Elements elements = document.select("ul.zs-list > li");
        for (org.jsoup.nodes.Element element : elements) {

            PaChongNew eachNew = new PaChongNew();

            Element img = element.selectFirst("img");
            if (img != null) {
                String srcUrl = img.attr("src");
                String[] split = srcUrl.split("/");
                // 标题url
                StringBuilder picUrl = new StringBuilder()
                        .append("http://www.ganjuren.com/uploads/allimg/")
                        .append(split[split.length - 2])
                        .append("/")
                        .append(split[split.length - 1]);
                //  System.out.println("图片url:"+picUrl);

                eachNew.setPicUrl(picUrl);
            }

            // 标题
            String title = element.selectFirst("strong").child(0).text();
            eachNew.setTitle(title);

            //详情页url
            String detailUrl = "http://www.ganjuren.com/" + element.selectFirst("strong").child(0).attr("href");
            eachNew.setDetailUrl(detailUrl);

            // 简述
            String introduction = element.selectFirst("p").text();
            eachNew.setIntroduction(introduction);

            // 发表时间
            String publishTime = element.selectFirst("span").text();
            eachNew.setPublishTime(publishTime);

            list.add(eachNew);
        }

        return R.ok().data("list", list);
    }

    @Override
    public R detail(DetailUrl detailUrl) {
        try {
            Document document = Jsoup.connect(detailUrl.getDetailUrl()).get();

            Elements elements = document.getElementsByClass("d-art");

            String html = elements.get(0).toString();
            System.out.println("----------------------");
            System.out.println(html);

            boolean isEnd = false;
            int nextSrc = 0;
            while (!isEnd){
                int srcIndex = html.indexOf("src",nextSrc);

                //对s2前面的src进行修改
                int srcBegin = html.indexOf("\"",srcIndex);
                int srcEnd = html.indexOf("\"",srcBegin+1);

//                System.out.println("srcBegin："+srcBegin);
//                System.out.println("srcBegin："+srcEnd);

                String srcContent = html.substring(srcBegin+1,srcEnd);
//                System.out.println("srcContent："+srcContent);

                String picUrl = "http://www.ganjuren.com"+srcContent;
//                System.out.println("picUrl："+picUrl);

                html=html.substring(0,srcBegin+1)+picUrl+html.substring(srcEnd);

                nextSrc  = html.indexOf("src", html.indexOf("\"",srcBegin+1));

//                System.out.println("nextSrc："+nextSrc);
                isEnd = nextSrc == -1;

//                System.out.println("\n\n");

            }

//            System.out.println("\n\n");
//            System.out.println(html);

            System.out.println("--------------------------------");
            System.out.println(html);

            return R.ok().data("htmlText", html);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error().message("爬取页面失败！");
        }
    }

    @Override
    public R newPaChong(Integer page) throws IOException {
        return null;
    }
}
