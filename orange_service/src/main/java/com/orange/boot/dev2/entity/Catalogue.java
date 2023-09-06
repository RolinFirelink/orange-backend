package com.orange.boot.dev2.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author LZH
 * @since 2022-06-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Catalogue对象", description="")
public class Catalogue implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "catalogue_id", type = IdType.AUTO)
    private Integer catalogueId;

    private String diseaseId;

    private String diseaseCharacteristic;

    private String disasterTypeId;

    private String citrusPartId;


}
