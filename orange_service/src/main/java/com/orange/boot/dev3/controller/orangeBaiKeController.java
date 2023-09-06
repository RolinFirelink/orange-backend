package com.orange.boot.dev3.controller;

import com.orange.boot.dev3.service.orangeBaiKeService;
import com.orange.boot.utils.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dev3/orangeBaiKe")
@Api(tags = "柑橘百科板块")
public class orangeBaiKeController {

     @Autowired
     orangeBaiKeService orangeBaiKeService;

     @GetMapping("orange")
     public R getOrangeBaiKe(){
         return orangeBaiKeService.getOrangeBaiKe();
     }

}
