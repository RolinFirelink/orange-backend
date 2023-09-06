package com.orange.boot.dev1.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.orange.boot.dev1.entity.NewsOverview;

import java.io.IOException;

/**
 * @author Rolin
 */
public interface NewsOverviewService extends IService<NewsOverview> {
    void timingCraw() throws IOException;

}
