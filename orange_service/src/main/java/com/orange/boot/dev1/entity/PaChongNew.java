package com.orange.boot.dev1.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author CZF
 * @create 2022-05-28 11:36
 */

@Data
@ApiModel("网站爬来的资讯列表")
public class PaChongNew implements Serializable {

    @ApiModelProperty("标题图片url")
    StringBuilder picUrl;

    @ApiModelProperty("标题")
    String title;

    @ApiModelProperty("详情页地址")
    String detailUrl;

    @ApiModelProperty("简述")
    String introduction;

    @ApiModelProperty("发表时间")
    String publishTime;


}
