package com.orange.boot.dev1.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Rolin
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="NewsHtml对象", description="用于返回新闻详情给前端")
public class NewsHtml {
    private String detailHtml;
}
