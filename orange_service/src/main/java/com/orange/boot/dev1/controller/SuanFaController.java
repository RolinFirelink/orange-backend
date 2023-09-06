package com.orange.boot.dev1.controller;

import com.orange.boot.dev2.service.DiseaseInformationService;
import com.orange.boot.utils.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author CZF
 * @create 2022-05-29 0:41
 */

@RestController
@RequestMapping("/dev1/test")
@Api(tags = "测试智能诊断，根据图片返回病名")
@CrossOrigin
public class SuanFaController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DiseaseInformationService diseaseInformationService;

    @GetMapping("/nameToID/{name}")
    public R nameToID(String name){
        return diseaseInformationService.nameToID(name);
    }

    @PostMapping("/intelligent_diagnosis")
    public R intelligent_diagnosis(MultipartFile pic){
        System.out.println("图片名为："+pic.getOriginalFilename());

        //todo:调用算法接口的url
        String url = "http://120.77.156.205:8802/getDiagnose";

        try {
            MultiValueMap<String,Object> bodyParams = new LinkedMultiValueMap<>();
            ByteArrayResource resource = new ByteArrayResource(pic.getBytes()){
                @Override
                public String getFilename() {
                    return pic.getOriginalFilename();
                }
            };

            bodyParams.add("pic",pic.getBytes());
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);//请求头设置内容类型为 multipart/form-data
            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity(pic.getBytes(), headers);
                                                                        //todo:返回类型可改
            R res= restTemplate.postForObject(url, requestEntity, R.class);

            System.out.println("算法接口返回的数据为："+res);

            return res;
            //测试rest用的
//            String url = "http://120.77.156.205:8808/wx/ucenter/test";
//            R res = restTemplate.getForObject(url, R.class);
//            System.out.println(res.getMessage());

        }catch (Exception e){
            e.printStackTrace();
            return R.error().message("调用算法失败！");
        }


    }
}
