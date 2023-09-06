package com.orange.boot.dev1.controller;


import com.orange.boot.dev1.service.EffectService;
import com.orange.boot.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author CZF
 * @since 2022-06-01
 */
@RestController
@RequestMapping("/dev1/effect")
@Api(tags = "柑橘功效")
public class EffectController {

    @Autowired
    EffectService effectService;

    @ApiOperation("条件、分页、模糊查询，模糊查询不必须传参，条件和分页必须传参")
    @GetMapping("/list")
    public R listPage(@RequestParam("page") @ApiParam("当前页") Long current,
                  @RequestParam("size") @ApiParam("每页大小") Integer limit,
                  @RequestParam(required = false,value = "like") @ApiParam("模糊查询") String like){
        return effectService.listPage(current,limit,like);
    }

    @ApiOperation("添加柑橘功效")
    @PostMapping("/add/{name}/{effectDetails}")
    public R addEffect(
            @PathVariable("name") String name,
            @PathVariable("effectDetails") String effectDetails,
            @RequestBody MultipartFile pic){
        return effectService.addEffect(name,effectDetails,pic);
    }

}

