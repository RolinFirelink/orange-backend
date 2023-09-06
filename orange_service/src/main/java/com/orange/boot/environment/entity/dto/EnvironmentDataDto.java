package com.orange.boot.environment.entity.dto;

import lombok.Data;

/**
 * @Author: Lin
 * @Date: 2022/9/9/14:26
 * @Description:
 */
@Data
public class EnvironmentDataDto {
    private Integer id;
    private String code;
    private String name;
    private Double value;
    private String valueText;
    private String unit;
    private String icon;
    private String level;
}
