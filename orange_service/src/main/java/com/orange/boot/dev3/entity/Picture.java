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
@ApiModel(value="Picture对象", description="")
public class Picture implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "图片集主键")
      @TableId(value = "picture_id", type = IdType.ASSIGN_ID)
    private String pictureId;

    @ApiModelProperty(value = "疾病主键")
    private String diseaseId;


    @ApiModelProperty(value = "图片")
    private String pictureUrl;

    @ApiModelProperty(value = "图片名称")
    private String pictureName;

    @ApiModelProperty(value = "疾病部位主键")
    private String citrusPartId;


}
