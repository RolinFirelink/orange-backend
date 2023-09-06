package com.orange.boot.dev3.controller;


import com.orange.boot.dev3.entity.Insecticide;
import com.orange.boot.dev3.service.InsecticideService;
import com.orange.boot.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author LWB
 * @since 2022-05-29
 */
@RestController
@RequestMapping("/orange_service/insecticide")
@Api(tags = "科学用药板块")
public class InsecticideController {

    @Autowired
    private InsecticideService insecticideService;

    @ApiOperation(value = "根据杀虫剂名，返回杀虫剂的基本信息")
    @GetMapping("getpicAndName/{insecticideName}")
    public R getInsecticideVo(String insecticideName){
        return insecticideService.getInsecticideVo(insecticideName);
    }

    @ApiOperation(value = "根据疾病名，返回所需杀虫剂")
    @GetMapping("getInsecticide/{diseaseName}")
    public R getInsecticide(String diseaseName){
        return insecticideService.getInsecticide(diseaseName);
    }

    @ApiOperation(value = "分页展示，返回各种病所需杀虫剂")
    @GetMapping("getAllInsecticide/{current}/{size}")
    public R getAllInsecticide(@PathVariable Long current,@PathVariable Long size){
        return insecticideService.getAllInsecticide(current, size);
    }

    @ApiOperation(value = "根据疾病名，返回对应杀虫剂的详细信息")
    @GetMapping("getInsecticideInfo/{insecticideName}")
    public R getInsecticideInfo(String diseaseName){
        return insecticideService.getInsecticideInfo(diseaseName);
    }

    @ApiOperation(value = "新增疾病")
    @PutMapping("insertInsecticide")
    public R insertInsecticide(@RequestBody Insecticide insecticide) {
        boolean save = insecticideService.save(insecticide);
        return save ? R.ok() : R.error("查询失败");
    }


}

