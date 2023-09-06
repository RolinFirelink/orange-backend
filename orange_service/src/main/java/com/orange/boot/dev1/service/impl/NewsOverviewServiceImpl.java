package com.orange.boot.dev1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orange.boot.dev1.entity.NewsDetails;
import com.orange.boot.dev1.entity.NewsOverview;
import com.orange.boot.dev1.mapper.NewsOverviewMapper;
import com.orange.boot.dev1.service.NewsDetailsService;
import com.orange.boot.dev1.service.NewsOverviewService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author Rolin
 */
@Service
public class NewsOverviewServiceImpl extends ServiceImpl<NewsOverviewMapper, NewsOverview>
        implements NewsOverviewService {

    @Autowired
    private NewsDetailsService newsDetailsService;

    @Override
    public void timingCraw() throws IOException {
        String url = "https://www.cnhnb.com/xt/search/?%E6%9F%91%E6%A9%98%E5%87%A4%E8%9D%B6";
        Document document = Jsoup.connect(url).get();
        Elements elements = document.selectXpath("//div[contains(@class,\"article-img\")]");
        int index = 1;
        for (Element item : elements) {
            NewsOverview overview = new NewsOverview();
            Element child = item.firstElementChild();
            String href = item.parent().attr("href");
            String URL = "https://www.cnhnb.com"+href;
            overview.setId((long) index);
            overview.setTitle(child.attr("alt"));
            overview.setImage(child.attr("src"));
            overview.setDetailUrl(URL);
            NewsOverview byId = this.getById(index);
            if(byId==null){
                this.save(overview);
            }else {
                overview.setImage(byId.getImage());
                this.updateById(overview);
            }
            StringBuilder sb = new StringBuilder();
            try {
                Document document1 = Jsoup.connect(URL).get();
                Elements elements1 = document1.selectXpath("//div[contains(@class,\"article-title\")]");
                sb.append(elements1.get(0).toString());
                elements1 = document1.selectXpath("//div[contains(@class,\"article-tips\")]");
                sb.append(elements1.get(0).toString());
                elements1 = document1.selectXpath("//div[contains(@class,\"article-desc\")]");
                sb.append(elements1.get(0).toString());
                elements1 = document1.selectXpath("//div[contains(@class,\"article-detail shrink\")]");
                sb.append(elements1.get(0).toString());
                int i = sb.indexOf("的精彩图文、热门评论，您可能对");
                if(i!=-1){
                    sb = new StringBuilder(sb.substring(0, i)+"的信息上面的内容就是全部了,如果你对这些内容感兴趣,可以收藏本网站");
                }
                NewsDetails detailsById = newsDetailsService.getById(index);
                NewsDetails details = new NewsDetails();
                details.setId((long) index);
                details.setOverviewId(overview.getId());
                details.setText(sb.toString());
                details.setUrl(URL);
//                System.out.println(sb);
                if(detailsById==null){
                    newsDetailsService.save(details);
                }else {
                    newsDetailsService.updateById(details);
                }
                index++;
            } catch (IOException e) {
                NewsDetails details = newsDetailsService.getById(index);
                details.setId((long) index);
                if (details==null) {
                    newsDetailsService.save(details);
                }else {
                    newsDetailsService.updateById(details);
                }
                index++;
                e.printStackTrace();
            }
        }
    }
}
