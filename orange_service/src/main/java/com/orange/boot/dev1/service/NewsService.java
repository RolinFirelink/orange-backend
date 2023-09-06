package com.orange.boot.dev1.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.orange.boot.dev1.entity.DetailUrl;
import com.orange.boot.dev1.entity.News;
import com.orange.boot.utils.R;

import java.io.IOException;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CZF
 * @since 2022-05-26
 */
public interface NewsService extends IService<News> {

    R getNews(int count);

    R paChong(Integer page);

    R detail(DetailUrl detailUrl);

    R newPaChong(Integer page) throws IOException;
}
