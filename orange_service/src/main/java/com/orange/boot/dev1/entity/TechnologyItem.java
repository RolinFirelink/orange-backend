package com.orange.boot.dev1.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author CZF
 * @create 2022-06-08 21:46
 */

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="种植技术列表每一项", description="种植技术列表每一项")
public class TechnologyItem implements Serializable {
    @ApiModelProperty("标题图片url")
    private String picUrl;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("详情地址")
    private String detailUrl;


}
