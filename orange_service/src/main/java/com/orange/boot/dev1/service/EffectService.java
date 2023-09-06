package com.orange.boot.dev1.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.orange.boot.dev1.entity.Effect;
import com.orange.boot.utils.R;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CZF
 * @since 2022-06-01
 */
public interface EffectService extends IService<Effect> {

    R listPage(Long current, Integer limit, String like);

    R addEffect(String name, String effectDetails, MultipartFile pic);
}
