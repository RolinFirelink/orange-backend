package com.orange.boot.dev2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.orange.boot.dev2.entity.DiseaseInformation;
import com.orange.boot.dev2.entity.vo.BrowseParamsVO;
import com.orange.boot.dev2.entity.vo.CatalogueVO;
import com.orange.boot.dev2.entity.vo.DiseasePictureNameVO;
import com.orange.boot.dev2.entity.vo.ShowDiseaseInfoVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author LZH
 * @since 2022-05-27
 */
public interface DiseaseInformationMapper extends BaseMapper<DiseaseInformation> {

    @Select({"SELECT disease_id,disease_chinese_name,disaster_type_name,disease_introduce,disease_symptom  FROM disease_information " +
            "LEFT JOIN disaster_type on disaster_type.disaster_type_id = disease_information.disaster_type_id WHERE is_deleted = 0"})
    Page<BrowseParamsVO> browseParams(Page<BrowseParamsVO> page);

    //如果使用到xml文件 则需要在这次夹加上@Param
    Page<BrowseParamsVO> browseLike(Page<BrowseParamsVO> page, @Param("diseaseChineseName") String diseaseChineseName,
                                    @Param("disasterTypeId")  String disasterTypeId, @Param("citrusPartId") String citrusPartId);

    @Select({"SELECT disease_chinese_name,disease_english_name,disease_trivial_name,disaster_type_name,disease_pathogen," +
            "disease_introduce,disease_symptom,disease_treatment,disease_distribution,disease_video,disease_weight,disease_picture_url  " +
            "FROM disease_information LEFT JOIN disaster_type ON disease_information.disaster_type_id = " +
            " disaster_type.disaster_type_id WHERE disease_id = #{disease_id} AND is_deleted = 0"})
    ShowDiseaseInfoVO showDiseaseInformation(String diseaseId);

    @Select({" SELECT disease_id , disease_picture_url,LEFT (disease_symptom ,25) as " +
            "disease_concise_description, disease_symptom  FROM disease_information WHERE is_deleted = 0 "})
    Page<DiseasePictureNameVO> showDiseasePictureName(Page<DiseasePictureNameVO> page);

    @Select({"SELECT disease_chinese_name,disease_english_name,disease_trivial_name,disaster_type_name,disease_pathogen," +
            "disease_introduce,disease_symptom,disease_treatment,disease_distribution,disease_video,disease_weight,disease_picture_url  " +
            "FROM disease_information LEFT JOIN disaster_type ON disease_information.disaster_type_id = " +
            " disaster_type.disaster_type_id WHERE disease_chinese_name like concat ( '%',#{diseaseChineseName},'%') AND is_deleted = 0"})
    List <ShowDiseaseInfoVO> diseaseForNameLike(String diseaseChineseName);

    Page<DiseasePictureNameVO> diseaseLike(Page<DiseasePictureNameVO>page,  @Param("diseaseChineseName") String diseaseChineseName,
                                           @Param("disasterTypeId") String  disasterTypeId,@Param("citrusPartId") String citrusPartId);

    List<CatalogueVO> catalogue(@Param("disasterTypeId") String disasterTypeId, @Param("citrusPartId") String citrusPartId);
}
