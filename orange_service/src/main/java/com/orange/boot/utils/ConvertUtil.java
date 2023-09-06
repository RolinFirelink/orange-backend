package com.orange.boot.utils;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xbx
 */
public class ConvertUtil {

    public static <T, S> List<T> convert(List<S> list, Class<? extends T> target) {
        List<T> vo = new ArrayList<>();
        list.forEach(l -> {
            T convert = convert(l, target);
            vo.add(convert);
        });
        return vo;
    }

    public static <T, S> T convert(S source, Class<? extends T> target) {
        if (source == null) {
            return null;
        }
        T vo = create(target);
        BeanUtils.copyProperties(source, vo);
        return vo;
    }

    public static <T> T create(Class<? extends T> target) {
        T vo = null;
        try {
            vo = target.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return vo;
    }
}
