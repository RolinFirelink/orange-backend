package com.orange.boot.dev2.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.orange.boot.dev2.entity.DiseaseInformation;
import com.orange.boot.dev2.entity.vo.BrowseParamsVO;
import com.orange.boot.dev2.entity.vo.CatalogueVO;
import com.orange.boot.dev2.entity.vo.DiseasePictureNameVO;
import com.orange.boot.dev2.entity.vo.ShowDiseaseInfoVO;
import com.orange.boot.utils.R;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author LZH
 * @since 2022-05-27
 */
public interface DiseaseInformationService extends IService<DiseaseInformation> {

    Page<BrowseParamsVO> browse(@Param("pageNum") Integer pageNum , @Param("pageSize") Integer pageSize);


    Page<BrowseParamsVO> browseLike(@Param("pageNum") Integer pageNum , @Param("pageSize") Integer pageSize,
                                    @Param("diseaseChineseName") String diseaseChineseName,
                                    @Param("disasterTypeId") String disasterTypeId, @Param("citrusPartId") String citrusPartId);

    ShowDiseaseInfoVO showDiseaseInformation(@Param("diseaseId") String diseaseId);

    Page<DiseasePictureNameVO> showDiseasePictureName(@Param("pageNum") Integer pageNum , @Param("pageSize") Integer pageSize);

    List<ShowDiseaseInfoVO> diseaseForNameLike(@Param("diseaseChineseName") String diseaseChineseName);


    Page<DiseasePictureNameVO> diseaseSelect(@Param("pageNum") Integer pageNum , @Param("pageSize") Integer pageSize,
                                             @Param("diseaseChineseName") String diseaseChineseName,
                                           @Param( "disasterTypeId") String disasterTypeId,@Param("citrusPartId") String citrusPartId);

    List<CatalogueVO> catalogue( @Param("disasterTypeId") String disasterTypeId, @Param("citrusPartId") String citrusPartId);

    R nameToID(String name);

    R logicDelete(String diseaseId);

    R addDiseaseInformation(@Param("diseaseInformation") DiseaseInformation diseaseInformation);

    R updateDiseaseInformation(DiseaseInformation diseaseInformation);
}
