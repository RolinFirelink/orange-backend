package com.orange.boot.dev3.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.orange.boot.dev3.entity.Picture;
import com.orange.boot.utils.R;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lwb
 * @since 2022-05-27
 */
public interface PictureService extends IService<Picture> {

    R addOrangePic(MultipartFile pic);

    R getpicAndName(String diseaseId, String citrusPartId);

    R getpic(String diseaseId);

    R getAllpic(String pictureName);


}
