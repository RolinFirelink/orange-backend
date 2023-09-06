package com.orange.boot.dev3.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.orange.boot.dev3.entity.Insecticide;
import com.orange.boot.utils.R;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author LWB
 * @since 2022-05-29
 */
public interface InsecticideService extends IService<Insecticide> {

    R getInsecticideVo(String insecticideName);

    R getInsecticide(String diseaseName);

    R getInsecticideInfo(String diseaseName);

    R getAllInsecticide(Long current, Long size);

}
