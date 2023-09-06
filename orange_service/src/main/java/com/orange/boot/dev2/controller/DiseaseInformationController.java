package com.orange.boot.dev2.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.orange.boot.dev2.entity.DiseaseInformation;
import com.orange.boot.dev2.entity.vo.BrowseParamsVO;
import com.orange.boot.dev2.entity.vo.CatalogueVO;
import com.orange.boot.dev2.entity.vo.DiseasePictureNameVO;
import com.orange.boot.dev2.entity.vo.ShowDiseaseInfoVO;
import com.orange.boot.dev2.service.DiseaseInformationService;
import com.orange.boot.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author LZH
 * @since 2022-05-27
 */
@RestController
@RequestMapping("/dev2/disease-information")
@Api(tags = "疾病防治")
public class DiseaseInformationController {

    @Autowired
    DiseaseInformationService diseaseInformationService;

    @ApiOperation("疾病预览----分页显示疾病")
    @GetMapping("/browse")
    public R browse(@ApiParam("页面数") @RequestParam("pageNum") Integer pageNum,
                    @ApiParam("页面大小") @RequestParam("pageSize") Integer pageSize){
        Page<BrowseParamsVO> browse = diseaseInformationService.browse(pageNum, pageSize);
        return R.ok().data("browse",browse);
    }

    @ApiOperation("疾病预览----分页模糊加多级查询疾病")
    @GetMapping("/browseLike")
    public R browseLike(@ApiParam("页面数") @RequestParam("pageNum") Integer pageNum,
                    @ApiParam("页面大小") @RequestParam("pageSize") Integer pageSize,
    @ApiParam(value = "疾病中文名称" )    @RequestParam(value = "diseaseChineseName",required = false,defaultValue = "") String diseaseChineseName,
    @ApiParam(value = "疾病类型" )    @RequestParam(value =  "disasterTypeId",required = false,defaultValue = "") String disasterTypeId,
    @ApiParam(value = "疾病部位" ) @RequestParam(value =  "citrusPartId",required = false,defaultValue = "") String citrusPartId
    ){
        Page<BrowseParamsVO> browse = diseaseInformationService.browseLike(pageNum, pageSize,diseaseChineseName,disasterTypeId,citrusPartId);
        return R.ok().data("browse",browse);
    }

    @ApiOperation("疾病预览、图文诊断、目检诊断 ----根据病名id 显示柑橘详情")
    @GetMapping("/showDiseaseInformation")
    public R showDiseaseInformation(@ApiParam("疾病主键") @RequestParam("diseaseId")String diseaseId ){
        ShowDiseaseInfoVO showDiseaseInfoVO = diseaseInformationService.showDiseaseInformation(diseaseId);
        return R.ok().data("showDiseaseInfoVO", showDiseaseInfoVO);
    }

    @ApiOperation("图文诊断--分页显示图文")
    @GetMapping("showDiseasePicture")
    public R showDiseasePictureName(@ApiParam("页面数") @RequestParam("pageNum") Integer pageNum,
                               @ApiParam("页面大小") @RequestParam("pageSize") Integer pageSize){

        Page<DiseasePictureNameVO> diseasePictureNameVOPage = diseaseInformationService.showDiseasePictureName(pageNum, pageSize);
        return R.ok().data("diseasePictureNameVOPage",diseasePictureNameVOPage);
    }

    @ApiOperation("图文诊断--模糊查询")
    @GetMapping("diseaseLike")
    public R diseaseLike(@ApiParam("疾病名称") @RequestParam(value = "diseaseChineseName",required = true)
                                     String diseaseChineseName){

        List<ShowDiseaseInfoVO> showDiseaseInfoVO = diseaseInformationService.diseaseForNameLike(diseaseChineseName);
        return R.ok().data("showDiseaseInfoVO", showDiseaseInfoVO);
    }

    @ApiOperation("图文诊断--分页模糊查询+多级查询")
    @GetMapping("diseaseSelect")
    public R diseaseSelect(@ApiParam("页面数") @RequestParam("pageNum") Integer pageNum,
                           @ApiParam("页面大小") @RequestParam("pageSize") Integer pageSize,
 @ApiParam(value = "疾病中文名称" )    @RequestParam(value = "diseaseChineseName",required = false,defaultValue = "") String diseaseChineseName,
            @ApiParam("疾病分类") @RequestParam(value = "disasterTypeId",required = false) String  disasterTypeId,
     @ApiParam("柑橘部位") @RequestParam(value = "citrusPartId",required = false) String citrusPartId   ){

        Page<DiseasePictureNameVO> diseasePictureNameVOPage = diseaseInformationService.diseaseSelect(pageNum, pageSize,diseaseChineseName, disasterTypeId, citrusPartId);

        return R.ok().data("diseasePictureNameVOPage", diseasePictureNameVOPage );

    }

    @ApiOperation("目录诊断----显示疾病特征")
    @GetMapping("/catalogue")
    public R catalogue( @ApiParam(value = "疾病类型" )    @RequestParam(value =  "disasterTypeId",required = false,defaultValue = "") String disasterTypeId,
                        @ApiParam(value = "疾病部位" ) @RequestParam(value =  "citrusPartId",required = false,defaultValue = "") String citrusPartId){
        List<CatalogueVO> catalogue = diseaseInformationService.catalogue(disasterTypeId, citrusPartId);
        return R.ok().data("catalogue",catalogue);
    }


    @ApiOperation("根据id逻辑删除")
    @DeleteMapping("/delete")
    public R logicDelete( @ApiParam(value = "疾病id") @RequestParam(value = "diseaseId",required = true) String diseaseId ){
        return diseaseInformationService.logicDelete(diseaseId);
    }

    @ApiOperation("增添疾病信息")
    @PostMapping("/add")
    public R addDiseaseInformation( @RequestBody DiseaseInformation diseaseInformation){
        return diseaseInformationService.addDiseaseInformation(diseaseInformation);
    }

    @ApiOperation("修改疾病信息")
    @PutMapping("/update")
    public R updateDiseaseInformation( @RequestBody DiseaseInformation diseaseInformation ){
        return diseaseInformationService.updateDiseaseInformation(diseaseInformation);
    }
}

