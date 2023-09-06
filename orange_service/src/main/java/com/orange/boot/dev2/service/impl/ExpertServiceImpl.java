package com.orange.boot.dev2.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orange.boot.dev2.entity.Expert;
import com.orange.boot.dev2.mapper.ExpertMapper;
import com.orange.boot.dev2.service.ExpertService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LZH
 * @since 2022-06-14
 */
@Service
public class ExpertServiceImpl extends ServiceImpl<ExpertMapper, Expert> implements ExpertService {

    @Resource
    ExpertMapper expertMapper;
    @Override
    @Transactional
    public Page<Expert> listExpertPage(long pageNum, long pageSize) {

        return expertMapper.getExpertList(new Page<Expert>(pageNum,pageSize));

    }
}
