package com.orange.boot.dev1.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Rolin
 */
@Data
@TableName("orange_overview")
public class NewsOverview {
    private Long id;
    private String title;
    private String image;
    private String detailUrl;
}
