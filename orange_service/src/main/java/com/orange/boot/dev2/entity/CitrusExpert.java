package com.orange.boot.dev2.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author Rolin
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="柑橘专家对象", description="")
public class CitrusExpert implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "柑橘专家id")
    @TableId(type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "柑橘专家头像")
    private String headUrl;

    @ApiModelProperty(value = "柑橘专家名字")
    private String name;

    @ApiModelProperty(value = "柑橘专家简介")
    private String introduction;

    @ApiModelProperty(value = "柑橘专家研究领域")
    private String researchArea;

    @ApiModelProperty(value = "柑橘专家所属机构")
    private String subsidiaryOrgan;

    @ApiModelProperty(value = "柑橘专家职称")
    private String appellation;
    @ApiModelProperty(value = "柑橘专家研究成果")
    private String researchResults;

    @ApiModelProperty(value = "柑橘专家手机号码")
    private String phone;

    @ApiModelProperty(value = "柑橘专家邮箱")
    private String email;
}