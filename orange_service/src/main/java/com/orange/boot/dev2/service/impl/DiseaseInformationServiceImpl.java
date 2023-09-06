package com.orange.boot.dev2.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orange.boot.dev2.entity.DiseaseInformation;
import com.orange.boot.dev2.entity.vo.BrowseParamsVO;
import com.orange.boot.dev2.entity.vo.CatalogueVO;
import com.orange.boot.dev2.entity.vo.DiseasePictureNameVO;
import com.orange.boot.dev2.entity.vo.ShowDiseaseInfoVO;
import com.orange.boot.dev2.mapper.DiseaseInformationMapper;
import com.orange.boot.dev2.service.DiseaseInformationService;
import com.orange.boot.dev3.entity.Picture;
import com.orange.boot.dev3.mapper.PictureMapper;
import com.orange.boot.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author LZH
 * @since 2022-05-27
 */
@Service
public class DiseaseInformationServiceImpl extends ServiceImpl<DiseaseInformationMapper, DiseaseInformation> implements DiseaseInformationService {

    @Resource
    DiseaseInformationMapper diseaseInformationMapper;

    @Override
    public Page<BrowseParamsVO> browse(Integer pageNum, Integer pageSize) {
        return diseaseInformationMapper.browseParams(new Page<BrowseParamsVO>(pageNum, pageSize));
    }

    @Override
    public Page<BrowseParamsVO> browseLike(Integer pageNum, Integer pageSize, String diseaseChineseName, String disasterTypeId, String citrusPartId) {
        return diseaseInformationMapper.browseLike(new Page<BrowseParamsVO>(pageNum, pageSize), diseaseChineseName, disasterTypeId, citrusPartId);
    }

    @Override
    public ShowDiseaseInfoVO showDiseaseInformation(String diseaseId) {
        return diseaseInformationMapper.showDiseaseInformation(diseaseId);
    }

    @Override
    public Page<DiseasePictureNameVO> showDiseasePictureName(Integer pageNum, Integer pageSize) {
        return diseaseInformationMapper.showDiseasePictureName(new Page<DiseasePictureNameVO>(pageNum, pageSize));
    }

    @Override
    public List<ShowDiseaseInfoVO> diseaseForNameLike(String diseaseChineseName) {
        return diseaseInformationMapper.diseaseForNameLike(diseaseChineseName);
    }

    @Override
    public Page<DiseasePictureNameVO> diseaseSelect(Integer pageNum, Integer pageSize, String diseaseChineseName, String disasterTypeId, String citrusPartId) {
        return diseaseInformationMapper.diseaseLike(new Page<DiseasePictureNameVO>(pageNum, pageSize), diseaseChineseName, disasterTypeId, citrusPartId);
    }

    @Override
    public List<CatalogueVO> catalogue(String disasterTypeId, String citrusPartId) {
        return diseaseInformationMapper.catalogue(disasterTypeId, citrusPartId);
    }

    /*@Override
    public R nameToID(String name) {
        String diseaseId;

        if(name.contains("叶片黄龙病")){
            diseaseId =  baseMapper.selectOne(new QueryWrapper<DiseaseInformation>().select("disease_id").like("disease_chinese_name","黄龙病")).getDiseaseId();
            return R.ok().data("diseaseId",diseaseId);
        }

        //柑橘xxx病 等同于 柑桔xxx病
        int index = name.contains("柑橘") ? name.indexOf("柑橘") : name.indexOf("柑桔");
        QueryWrapper<DiseaseInformation> wrapper = new QueryWrapper<>();
        if (index != -1) {
            if(name.length() == 2) return R.error().message("找不到改疾病的id");
            wrapper.select("disease_id").like("disease_chinese_name", name.substring(index + 2));
            diseaseId = baseMapper.selectOne(wrapper).getDiseaseId();
        } else {
            wrapper.select("disease_id").like("disease_chinese_name",name);
            diseaseId = baseMapper.selectOne(wrapper).getDiseaseId();
        }
        if(diseaseId.isEmpty()) return R.error().message("找不到改疾病的id");

        return R.ok().data("diseaseId",diseaseId);
    }*/


    @Override
    public R nameToID(String name) {

        LambdaQueryWrapper<DiseaseInformation> lambdaQueryWrapper = new LambdaQueryWrapper();
        String diseaseId = null;
        int length =  name.length();
//        if(length == 3 ){
//             diseaseId = baseMapper.selectOne(lambdaQueryWrapper.select(DiseaseInformation::getDiseaseId).like(DiseaseInformation::getDiseaseChineseName, name)).getDiseaseId();
//        }
        if(name.contains("柑橘") || name.contains("柑桔") || name.contains("叶片") ||name.contains("果实")){
            name = name.substring(2);
        }
        diseaseId = baseMapper.selectOne(lambdaQueryWrapper.select(DiseaseInformation::getDiseaseId).like(DiseaseInformation::getDiseaseChineseName, name)).getDiseaseId();

        return diseaseId != null ?  R.ok().data("diseaseId",diseaseId) : R.error("查无此数据");


    }

    @Override
    public R logicDelete(String diseaseId) {
        int i = diseaseInformationMapper.deleteById(diseaseId);
        return i > 0 ? R.ok() :R.error();
    }

    @Autowired
    private PictureMapper pictureMapper;

    @Transactional
    @Override
    public R addDiseaseInformation(DiseaseInformation diseaseInformation) {

        // id自动生成
        int insert = diseaseInformationMapper.insert(diseaseInformation);
        Picture picture  = new Picture();

        picture.setDiseaseId(diseaseInformation.getDiseaseId());
        picture.setPictureName(diseaseInformation.getDiseaseChineseName());
        picture.setCitrusPartId(diseaseInformation.getCitrusPartId());
        picture.setPictureUrl(diseaseInformation.getDiseasePictureUrl());

        int insert1 = pictureMapper.insert(picture);

        return insert1 == insert ? R.ok(): R.error();
    }

    @Override
    @Transactional
    public R updateDiseaseInformation( DiseaseInformation diseaseInformation ) {

        // 更改疾病细信息
        LambdaUpdateWrapper<DiseaseInformation> updateWrapper = new LambdaUpdateWrapper<>();
        // 判断是否传入id
        if(!StringUtils.hasText(diseaseInformation.getDiseaseId())){
            throw new  RuntimeException("修改信息没有传入id");
        }

        updateWrapper.eq(DiseaseInformation::getDiseaseId,diseaseInformation.getDiseaseId());
        updateWrapper.set(StringUtils.hasText(diseaseInformation.getDiseaseChineseName()),DiseaseInformation::getDiseaseChineseName,diseaseInformation.getDiseaseChineseName());
        updateWrapper.set(StringUtils.hasText( diseaseInformation.getDiseaseEnglishName()),DiseaseInformation::getDiseaseEnglishName , diseaseInformation.getDiseaseEnglishName());
        updateWrapper.set(StringUtils.hasText(diseaseInformation.getDiseaseTrivialName()),DiseaseInformation::getDiseaseTrivialName,diseaseInformation.getDiseaseTrivialName());
        updateWrapper.set(StringUtils.hasText(diseaseInformation.getDiseaseTreatment()), DiseaseInformation::getDiseaseTreatment,diseaseInformation.getDiseaseTreatment());
        updateWrapper.set(StringUtils.hasText(diseaseInformation.getDisasterTypeId()),DiseaseInformation::getDisasterTypeId,diseaseInformation.getDisasterTypeId());
        updateWrapper.set(StringUtils.hasText( diseaseInformation.getDiseasePathogen()),DiseaseInformation::getDiseasePathogen , diseaseInformation.getDiseasePathogen());
        updateWrapper.set(StringUtils.hasText(diseaseInformation.getDiseasePictureUrl()), DiseaseInformation::getDiseasePictureUrl,diseaseInformation.getDiseasePictureUrl());
        updateWrapper.set(StringUtils.hasText(diseaseInformation.getDiseaseIntroduce()),DiseaseInformation::getDiseaseIntroduce,diseaseInformation.getDiseaseIntroduce());
        updateWrapper.set(DiseaseInformation::getDiseaseIntelligence , 0); // 暂时固定
        updateWrapper.set(StringUtils.hasText(diseaseInformation.getCitrusPartId()), DiseaseInformation::getCitrusPartId,diseaseInformation.getCitrusPartId());
        updateWrapper.set(DiseaseInformation::getDiseaseWeight,80);
        updateWrapper.set(StringUtils.hasText(diseaseInformation.getDiseaseDistribution()), DiseaseInformation::getDiseaseDistribution,diseaseInformation.getDiseaseDistribution());
        updateWrapper.set(StringUtils.hasText(diseaseInformation.getDiseaseVideo()),DiseaseInformation::getDiseaseVideo,diseaseInformation.getDiseaseVideo());
        // updateById
        int update = diseaseInformationMapper.update(diseaseInformation,updateWrapper);

        return update == 1 ? R.ok() : R.error();

    }


}
