package com.orange.boot.dev2.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @Author: lzh
 * @Date: 2022/6/7 0:01
 */

public class CatalogueVO {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String diseaseId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String diseaseCharacteristic;


}
