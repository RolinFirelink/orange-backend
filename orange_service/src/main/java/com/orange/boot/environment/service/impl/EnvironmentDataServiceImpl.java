package com.orange.boot.environment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orange.boot.environment.entity.EnvironmentData;
import com.orange.boot.environment.mapper.EnvironmentDataMapper;
import com.orange.boot.environment.service.EnvironmentDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Author: Lin
 * @Date: 2022/9/9/14:34
 * @Description:
 */
@Service
public class EnvironmentDataServiceImpl extends ServiceImpl<EnvironmentDataMapper, EnvironmentData> implements EnvironmentDataService {

    @Resource
    EnvironmentDataMapper mapper;

    @Override
    public List<EnvironmentData> getEnvironmentData(String code) {
        QueryWrapper<EnvironmentData> queryWrapper = new QueryWrapper<EnvironmentData>().eq("code", code)
                .orderByAsc("gmt_create")
                        .last("LIMIT 20");
        List<EnvironmentData> environmentDatas = mapper.selectList(queryWrapper);
        List<EnvironmentData> list = new ArrayList<>();
        String dateString = "2022-09-09 10:00:00";
        for (int i = 0; i < 10; i++) {
            EnvironmentData item = environmentDatas.get(i);
            Date gmtCreate;
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            dateString=dateString.substring(0,11)+(40+i)+dateString.substring(13);
            try {
                gmtCreate = format.parse(dateString);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            item.setGmtCreate(gmtCreate);
            list.add(item);
        }
        return list.size() != 0 ? list : null;
    }
}
