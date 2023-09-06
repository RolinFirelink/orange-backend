package com.orange.boot.dev1.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Rolin
 */
@Data
@TableName("orange_details")
public class NewsDetails {
    private Long id;
    private Long overviewId;
    private String text;
    private String url;
}
