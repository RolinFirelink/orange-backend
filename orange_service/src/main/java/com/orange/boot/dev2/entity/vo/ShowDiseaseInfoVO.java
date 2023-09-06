package com.orange.boot.dev2.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: lzh
 * @Date: 2022/5/28 13:01
 */
public class ShowDiseaseInfoVO {



    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String diseaseChineseName;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String diseaseEnglishName;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String diseaseTrivialName;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String disasterTypeName;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String diseasePathogen;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String diseaseIntroduce;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String diseaseSymptom;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String diseaseTreatment;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty(value = "疾病权重")
    private Float diseaseWeight;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String diseaseDistribution;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String diseaseVideo;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String diseasePictureUrl;

}
