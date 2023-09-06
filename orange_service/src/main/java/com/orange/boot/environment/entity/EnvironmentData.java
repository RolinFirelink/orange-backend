package com.orange.boot.environment.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

/**
 * @Author: Lin
 * @Date: 2022/9/9/14:12
 * @Description:
 */
@TableName("t_environment_data")
@Data
@ApiModel(value="Insecticide对象", description="接收环境数据")
public class EnvironmentData {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("data_id")
    private Integer dataId;

    @TableField("code")
    private String code;

    @TableField("name")
    private String name;

    @TableField("value")
    private Double value;

    @TableField("value_text")
    private String valueText;

    @TableField("unit")
    private String unit;

    @TableField("icon")
    private String icon;

    @TableField("level")
    private Integer level;

    @TableField("source_machine")
    private Long sourceMachine;

    @TableField(value = "gmt_create", fill = FieldFill.INSERT)
    private Date gmtCreate;

    @TableField(value = "is_deleted", fill = FieldFill.INSERT)
    @JsonIgnore
    private boolean isDelete;

    @TableField("version")
    @Version
    private Integer version;

    public EnvironmentData(Integer id, String code, String name, Double value, String valueText, String unit, String icon, Integer level, Long sourceMachine) {
        this.dataId = id;
        this.code = code;
        this.name = name;
        this.value = value;
        this.valueText = valueText;
        this.unit = unit;
        this.icon = icon;
        this.level = level;
        this.sourceMachine = sourceMachine;
    }

    public EnvironmentData() {
    }
}
