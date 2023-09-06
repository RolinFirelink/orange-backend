package com.orange.boot.dev1.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author CZF
 * @create 2022-05-28 16:27
 */
@Data
@ApiModel("详情页url")
public class DetailUrl implements Serializable {
    @ApiModelProperty("详情页url")
    String detailUrl;
}
