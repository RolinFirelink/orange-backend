package com.orange.boot.dev2.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Setter;

/**
 * @Author: lzh
 * @Date: 2022/5/27 21:35
 */

@Setter
public class BrowseParamsVO {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String diseaseId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String diseaseSymptom;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String disasterTypeName;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String diseaseIntroduce;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String diseaseChineseName;

}

