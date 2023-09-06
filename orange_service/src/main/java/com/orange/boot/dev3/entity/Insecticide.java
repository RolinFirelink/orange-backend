package com.orange.boot.dev3.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @author LWB
 * @since 2022-05-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Insecticide对象", description="")
public class Insecticide implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Integer id;

    @ApiModelProperty(value = "农药名")
    private String insecticideName;

    @ApiModelProperty(value = "农药英文名")
    private String englishName;

    @ApiModelProperty(value = "病害名称")
    private String diseaseName;

    @ApiModelProperty(value = "剂型")
    private String type;

    @ApiModelProperty(value = "有效成分")
    private String activeConstituent;

    @ApiModelProperty(value = "农药登记号")
    private String certificateNumber;

    @ApiModelProperty(value = "使用介绍")
    private String instruction;

    @ApiModelProperty(value = "注意事项")
    private String attention;

    @ApiModelProperty(value = "中毒急救")
    private String  emergencyTreatment;


    @ApiModelProperty(value = "备注，其他说明")
    private String remarks;

    @ApiModelProperty(value = "可以治什么病")
    private String effect;


}
