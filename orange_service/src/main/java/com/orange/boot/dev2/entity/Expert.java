package com.orange.boot.dev2.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author LZH
 * @since 2022-06-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Expert对象", description="")
public class Expert implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "专家id")
      @TableId(value = "expert_id", type = IdType.AUTO)
    private Long expertId;

    @ApiModelProperty(value = "专家名字")
    private String expertName;

    @ApiModelProperty(value = "专家手机号")
    private String expertPhone;

    @ApiModelProperty(value = "专家照片")
    private String expertPhoto;

    @ApiModelProperty(value = "专家介绍")
    private String expertIntroduction;

    @ApiModelProperty(value = "曾获荣誉")
    private String expertHonor;

    @ApiModelProperty(value = "专家领域")
    private String expertTerritory;

    @ApiModelProperty(value = "创建时间",hidden = true)
    @TableField(fill = FieldFill.INSERT)
    @JsonIgnore
    private Date gmtCreate;

    @ApiModelProperty(value = "修改时间",hidden = true)
    @TableField(fill = FieldFill.UPDATE)
    @JsonIgnore
    private Date gmtModified;

    @ApiModelProperty(value = "逻辑删除",hidden = true)
    @TableField(fill = FieldFill.INSERT)
    @JsonIgnore
    @TableLogic
    private Integer isDeleted;

    @ApiModelProperty(value = "被问次数")
    private Integer beAskedNumber;

    @ApiModelProperty(value = "回答次数")
    private Integer answerNumber;

    @ApiModelProperty(value = "年龄")
    private Integer year;

    @ApiModelProperty(value = "微信号")
    private String wx;

    @ApiModelProperty(value = "头衔")
    private String title;


}
