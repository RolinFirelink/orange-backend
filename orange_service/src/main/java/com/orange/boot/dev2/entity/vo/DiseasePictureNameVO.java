package com.orange.boot.dev2.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @Author: lzh
 * @Date: 2022/5/28 23:53
 */

public class DiseasePictureNameVO {



    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String diseaseId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String diseasePictureUrl;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String diseaseSymptom;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String diseaseConciseDescription;

}
