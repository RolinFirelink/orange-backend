package com.orange.boot.dev2.entity.vo;

import lombok.Data;

/**
 * @Author: lzh
 * @Date: 2022/11/25 0:04
 */


@Data
public class forecastVO {

    int[] res = new int[12];
    String support;

}
