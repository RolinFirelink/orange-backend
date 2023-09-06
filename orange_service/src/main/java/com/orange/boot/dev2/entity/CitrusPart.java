package com.orange.boot.dev2.entity;

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
 * @author LZH
 * @since 2022-05-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="CitrusPart对象", description="")
public class CitrusPart implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "柑橘部位主键")
      @TableId(value = "citrus_part_id", type = IdType.ASSIGN_ID)
    private String citrusPartId;

    @ApiModelProperty(value = "柑橘部位名称")
    private String citrusPartName;


}
