package com.orange.boot.dev2.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author LZH
 * @since 2022-05-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="DiseaseInformation对象", description="")
public class DiseaseInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "疾病主键")
      @TableId(value = "disease_id", type = IdType.ASSIGN_ID)
    private String diseaseId;

    @ApiModelProperty(value = "	疾病中文名")
    private String diseaseChineseName;

    @ApiModelProperty(value = "疾病英文名")
    private String diseaseEnglishName;

    @ApiModelProperty(value = "疾病俗名、常见名")
    private String diseaseTrivialName;

    @ApiModelProperty(value = "疾病分类")
    private String disasterTypeId;

    @ApiModelProperty(value = "疾病病原物")
    private String diseasePathogen;

    @ApiModelProperty(value = "疾病简介")
    private String diseaseIntroduce;

    @ApiModelProperty(value = "疾病主要症状")
    private String diseaseSymptom;

    @ApiModelProperty(value = "疾病防治措施")
    private String diseaseTreatment;

    @ApiModelProperty(value = "疾病部位")
    private String citrusPartId;

    @ApiModelProperty(value = "疾病权重")
    private Float diseaseWeight;

    @ApiModelProperty(value = "疾病分布")
    private String diseaseDistribution;

    @ApiModelProperty(value = "疾病防控视频")
    private String diseaseVideo;

    @ApiModelProperty(value = "疾病智能识别id")
    private Integer diseaseIntelligence;

    @ApiModelProperty(value = "疾病图像")
    private String diseasePictureUrl;

    @ApiModelProperty(value = "逻辑删除")
    @TableLogic
    private Integer isDeleted;




}
