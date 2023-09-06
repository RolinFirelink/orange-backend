package com.orange.boot.dev1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orange.boot.dev1.entity.NewsDetails;
import com.orange.boot.dev1.mapper.NewsDetailsMapper;
import com.orange.boot.dev1.service.NewsDetailsService;
import org.springframework.stereotype.Service;

/**
 * @author Rolin
 */
@Service
public class NewsDetailsServiceImpl extends ServiceImpl<NewsDetailsMapper, NewsDetails>
        implements NewsDetailsService {


}
