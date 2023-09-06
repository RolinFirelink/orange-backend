package com.orange.boot.dev2.controller;


import com.orange.boot.dev2.entity.Expert;
import com.orange.boot.dev2.service.ExpertService;
import com.orange.boot.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/dev2/expert")
@Api(tags="在线专家")

public class ExpertController {

    @Resource
    ExpertService expertService;

    @ApiOperation(value = "专家详情")
    @GetMapping("/get")
    public R get(Long id){
        Expert expert = expertService.getById(id);
        return expert != null? R.ok().data("expert",expert) : R.error().message("查询失败");
    }


   /* @ApiOperation(value = "分页返回所有专家")
    @GetMapping("/getList")
    public R getList(@RequestParam("page")Integer page,
                          @RequestParam("pageSize")Integer pageSize){

        PageHelper.startPage(page,pageSize);
        List<Expert> expertList = expertService.list();
        PageInfo<Expert> pageInfo = new PageInfo<Expert>(expertList);
        PageVO<Expert> expertPageVO = new PageVO<>();
        BeanUtils.copyProperties(pageInfo,expertPageVO);
        expertPageVO.setResult(pageInfo.getList());
        expertPageVO.setPage(page);
        return R.ok().data("expertPageVO",expertPageVO);

    }*/


}

