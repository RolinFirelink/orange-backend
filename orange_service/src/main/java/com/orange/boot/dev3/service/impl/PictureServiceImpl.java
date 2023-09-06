package com.orange.boot.dev3.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orange.boot.dev3.entity.Picture;
import com.orange.boot.dev3.entity.vo.PictureVo;
import com.orange.boot.dev3.entity.vo.pictureListVo;
import com.orange.boot.dev3.mapper.PictureMapper;
import com.orange.boot.dev3.service.PictureService;
import com.orange.boot.utils.IpAndPortUtil;
import com.orange.boot.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lwb
 * @since 2022-05-27
 */
@Service
public class PictureServiceImpl extends ServiceImpl<PictureMapper, Picture> implements PictureService {

    @Value("${uploadPath}")
    String uploadPath;

    @Autowired
    private PictureService pictureService;


    @Override
    public R addOrangePic(MultipartFile pic) {

        if (pic != null) {
            String fileName = System.currentTimeMillis() + pic.getOriginalFilename();

            //第一次运行的时候，这个文件所在的目录往往是不存在的，这里需要创建一下目录
            File dir = new File(uploadPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            //把浏览器上传的文件复制到希望的位置
            File targetFile = new File(uploadPath, fileName);
            try {
                pic.transferTo(targetFile);
            } catch (IOException e) {
                e.printStackTrace();
                return R.error().message("上传失败");
            }

            //服务器的ip和端口号
            String ipAndPort = IpAndPortUtil.getIpAndPort();
            String picUrl = "http://"+ipAndPort+"/news/"+fileName;

            //返回获取图片的url
            return R.ok().data("picUrl", picUrl);

        } else {
            return R.error().message("上传的文件为空！");
        }
    }

    @Override
    public R getpicAndName(String diseaseId, String citrusPartId) {

        QueryWrapper<Picture> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("disease_id",diseaseId);
        queryWrapper.eq("citrus_part_id",citrusPartId);

        List<Picture> pictureList = pictureService.list(queryWrapper);
        ArrayList<pictureListVo> list = new ArrayList<>();

        for (Picture picture : pictureList) {
            pictureListVo listVo = new pictureListVo();
            listVo.setPictureUrl(picture.getPictureUrl());
            listVo.setPictureName(picture.getPictureName());
            list.add(listVo);
        }

        return R.ok().data("list",list);
    }

    @Override
    public R getpic(String diseaseId) {

        QueryWrapper<Picture> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("disease_id",diseaseId);

        List<Picture> pictureList = pictureService.list(queryWrapper);
        int size = pictureList.size();
        PictureVo[] pictureVos = new PictureVo[size];

        for (int i = 0; i < size; i++) {
            Picture picture = pictureList.get(i);
            PictureVo pictureVo = new PictureVo();
            pictureVo.setPicUrls(picture.getPictureUrl());
            pictureVo.setPicName(picture.getPictureName());
            pictureVos[i] = pictureVo;
        }

        return R.ok().data("pictureVos",pictureVos);
    }

    @Override
    public R getAllpic(String pictureName) {

        QueryWrapper<Picture> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("picture_name",pictureName);

        List<Picture> pictureList = pictureService.list(queryWrapper);
        ArrayList<String> List = new ArrayList<>();

        for (Picture picture : pictureList) {
            List.add(picture.getPictureUrl());
        }
        return R.ok().data("List",List);
    }
}
