package com.orange.boot.dev2.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.orange.boot.dev2.entity.CitrusExpert;
import com.orange.boot.dev2.service.CitrusExpertService;
import com.orange.boot.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author LZH
 * @since 2022-06-14
 */
@RestController
@RequestMapping("/dev2/citrus_expert")
@Api(tags="在线柑橘专家")

public class CitrusExpertController {

    @Resource
    CitrusExpertService citrusExpertService;

    @ApiOperation("增添专家信息")
    @PostMapping("/add")
    public R addDiseaseInformation( @RequestBody CitrusExpert citrusExpert){
        return citrusExpertService.save(citrusExpert) ? R.ok().message("添加成功") : R.error("添加失败,请稍后再试");
    }

    @ApiOperation("修改专家信息")
    @PutMapping("/update")
    public R updateDiseaseInformation( @RequestBody CitrusExpert citrusExpert){
        return citrusExpertService.updateById(citrusExpert) ? R.ok().message("修改成功") : R.error("修改失败,请稍后再试");
    }

    @ApiOperation("根据id删除")
    @DeleteMapping("/delete")
    public R delete( @ApiParam(value = "专家id") @RequestParam(value = "id") Long id ){
        return citrusExpertService.removeById(id) ? R.ok().message("删除成功") : R.error("删除失败,请稍后再试");
    }

    @ApiOperation("根据id获取")
    @GetMapping("/get")
    public R get( @ApiParam(value = "专家id") @RequestParam(value = "id") Long id ){
        CitrusExpert byId = citrusExpertService.getById(id);
        return byId !=null ? R.ok().message("获取成功").data("result",byId) : R.error("获取失败,请稍后再试");
    }

    @ApiOperation("分页显示专家信息")
    @GetMapping("/browse")
    public R browse(@ApiParam("页面数") @RequestParam("page") Integer pageNum,
                    @ApiParam("页面大小") @RequestParam("size") Integer pageSize){
        Page<CitrusExpert> browse = citrusExpertService.page(new Page<>(pageNum,pageSize));
        return R.ok().data("browse",browse);
    }
}

