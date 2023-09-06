package com.orange.boot.dev3.controller;


import com.orange.boot.dev3.service.PictureService;
import com.orange.boot.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lwb
 * @since 2022-05-27
 */

@RestController
@RequestMapping("/dev3/picture")
@Api(tags = "疾病图片板块")
public class PictureController {

    @Autowired
    public PictureService pictureService;

    @ApiOperation(value = "上传柑橘的图片，返回图片路径")
    @PostMapping("addOrangePic")
     public R addOrangePic(MultipartFile pic){
            return pictureService.addOrangePic(pic);
        }

    @ApiOperation(value = "根据疾病id和疾病部位id，返回图片路径和名称")
    @GetMapping("getpicAndName/{diseaseId}/{citrusPartId}")
    public R getpicAndName(@PathVariable String diseaseId,@PathVariable String citrusPartId){
        return pictureService.getpicAndName(diseaseId, citrusPartId);
    }

    @ApiOperation(value = "根据疾病id，返回疾病图片路径和疾病名称")
    @GetMapping("getpicAndName/{diseaseId}")
    public R getpicAndName(@PathVariable String diseaseId){
        return pictureService.getpic(diseaseId);
    }

    @ApiOperation(value = "根据疾病名，返回所有疾病图片集")
    @GetMapping("getAllpic/{pictureName}")
    public R getAllpic(@PathVariable String pictureName){
        return pictureService.getAllpic(pictureName);
    }

 }





