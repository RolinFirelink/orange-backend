package com.orange.boot.dev3.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orange.boot.dev3.entity.Insecticide;
import com.orange.boot.dev3.entity.vo.insecticideInfoVo;
import com.orange.boot.dev3.entity.vo.insecticideVo;
import com.orange.boot.dev3.mapper.InsecticideMapper;
import com.orange.boot.dev3.service.InsecticideService;
import com.orange.boot.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LWB
 * @since 2022-05-29
 */
@Service
public class InsecticideServiceImpl extends ServiceImpl<InsecticideMapper, Insecticide> implements InsecticideService {

    @Autowired
    private InsecticideService insecticideService;


    @Override
    public R getInsecticideVo(String insecticideName) {

        QueryWrapper<Insecticide> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("insecticide_name",insecticideName);

        List<Insecticide> list = insecticideService.list(queryWrapper);
        ArrayList<insecticideVo> insecticideVoArrayList = new ArrayList<>();

        for (Insecticide insecticide : list) {

            insecticideVo insecticideVo = new insecticideVo();

            insecticideVo.setInsecticideName(insecticide.getInsecticideName());
            insecticideVo.setAttention(insecticide.getAttention());
            insecticideVo.setEmergencyTreatment(insecticide.getEmergencyTreatment());
            insecticideVo.setInstruction(insecticide.getInstruction());
            insecticideVo.setRemarks(insecticide.getRemarks());
            insecticideVo.setEffect(insecticide.getEffect());
            insecticideVoArrayList.add(insecticideVo);
        }

        return  R.ok().data("insecticideVoArrayList",insecticideVoArrayList);

    }

    @Override
    public R getInsecticide(String diseaseName) {

        QueryWrapper<Insecticide> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("disease_name",diseaseName);

        List<Insecticide> insecticideList = insecticideService.list(queryWrapper);

        ArrayList<insecticideInfoVo> list = new ArrayList<>();
        for (Insecticide insecticide : insecticideList) {
            insecticideInfoVo insecticideInfoVo = new insecticideInfoVo();
            insecticideInfoVo.setType(insecticide.getType());
            insecticideInfoVo.setRemarks(insecticide.getRemarks());
            insecticideInfoVo.setInstruction(insecticide.getInstruction());
            insecticideInfoVo.setInsecticideName(insecticide.getInsecticideName());
            insecticideInfoVo.setEnglishName(insecticide.getEnglishName());
            insecticideInfoVo.setEmergencyTreatment(insecticide.getEmergencyTreatment());
            insecticideInfoVo.setDiseaseName(insecticide.getDiseaseName());
            insecticideInfoVo.setCertificateNumber(insecticide.getCertificateNumber());
            insecticideInfoVo.setAttention(insecticide.getAttention());
            insecticideInfoVo.setActiveConstituent(insecticide.getActiveConstituent());
            insecticideInfoVo.setEffect(insecticide.getEffect());
            list.add(insecticideInfoVo);
        }
        return R.ok().data("list",list);
    }

    @Override
    public R getInsecticideInfo(String diseaseName) {

        QueryWrapper<Insecticide> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("disease_name",diseaseName);

        List<Insecticide> insecticideList = insecticideService.list(queryWrapper);
        ArrayList<insecticideInfoVo> insecticideInfoVos = new ArrayList<>();

        for (Insecticide insecticide : insecticideList) {
            insecticideInfoVo insecticideInfoVo = new insecticideInfoVo();
            insecticideInfoVo.setType(insecticide.getType());
            insecticideInfoVo.setRemarks(insecticide.getRemarks());
            insecticideInfoVo.setInstruction(insecticide.getInstruction());
            insecticideInfoVo.setInsecticideName(insecticide.getInsecticideName());
            insecticideInfoVo.setEnglishName(insecticide.getEnglishName());
            insecticideInfoVo.setEmergencyTreatment(insecticide.getEmergencyTreatment());
            insecticideInfoVo.setDiseaseName(insecticide.getDiseaseName());
            insecticideInfoVo.setCertificateNumber(insecticide.getCertificateNumber());
            insecticideInfoVo.setAttention(insecticide.getAttention());
            insecticideInfoVo.setActiveConstituent(insecticide.getActiveConstituent());
            insecticideInfoVo.setEffect(insecticide.getEffect());
            insecticideInfoVos.add(insecticideInfoVo);
        }

        return R.ok().data("insecticideInfoVos",insecticideInfoVos);
    }

    @Override
    public R getAllInsecticide(Long current, Long size) {
        //创建page
        Page<Insecticide> pageInsecticide = new Page<>(current, size);
        //构建条件
        QueryWrapper<Insecticide> wrapper = new QueryWrapper<>();

        insecticideService.page(pageInsecticide);

        long total = pageInsecticide.getTotal();
        List<Insecticide> insecticideList = pageInsecticide.getRecords();
        ArrayList<insecticideInfoVo> list = new ArrayList<>();

        for (Insecticide insecticide : insecticideList) {
            insecticideInfoVo insecticideInfoVo = new insecticideInfoVo();
            insecticideInfoVo.setType(insecticide.getType());
            insecticideInfoVo.setRemarks(insecticide.getRemarks());
            insecticideInfoVo.setInstruction(insecticide.getInstruction());
            insecticideInfoVo.setInsecticideName(insecticide.getInsecticideName());
            insecticideInfoVo.setEnglishName(insecticide.getEnglishName());
            insecticideInfoVo.setEmergencyTreatment(insecticide.getEmergencyTreatment());
            insecticideInfoVo.setDiseaseName(insecticide.getDiseaseName());
            insecticideInfoVo.setCertificateNumber(insecticide.getCertificateNumber());
            insecticideInfoVo.setAttention(insecticide.getAttention());
            insecticideInfoVo.setActiveConstituent(insecticide.getActiveConstituent());
            insecticideInfoVo.setEffect(insecticide.getEffect());
            list.add(insecticideInfoVo);
        }

        HashMap<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return R.ok().data(map);

    }
}
