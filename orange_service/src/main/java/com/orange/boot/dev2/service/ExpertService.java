package com.orange.boot.dev2.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.orange.boot.dev2.entity.Expert;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author LZH
 * @since 2022-06-14
 */
public interface ExpertService extends IService<Expert> {

    Page<Expert> listExpertPage(long pageNum, long pageSize);

}
