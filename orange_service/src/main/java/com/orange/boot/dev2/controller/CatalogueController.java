package com.orange.boot.dev2.controller;


import com.orange.boot.dev2.entity.vo.forecastVO;
import com.orange.boot.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author LZH
 * @since 2022-06-06
 */
@RestController
@RequestMapping("/dev2/catalogue")
@Api(tags = "环境预测" ,description = "")
public class CatalogueController {

    @ApiOperation(value = "环境预测")
    @GetMapping("/environmentForecast")
    public R environmentForecast(  @ApiParam("预测模型") @RequestParam("model") String model, @ApiParam("环境参数") @RequestParam("parameter") String parameter) {

        // 获取时间
//        Date date = new Date();
//        SimpleDateFormat df = new SimpleDateFormat("HH");
//        String str = df.format(date);
//        int a = Integer.parseInt(str);
//        if (9 <= a && a <= 17) {
//            System.out.println("上午");

         //返回参数
         forecastVO forecastVO = new forecastVO();
         int[] parameters;



            if (parameter.equals("二氧化碳")) {

                if (model == "线性回归") {
                    parameters = new int[]{310, 400, 456, 512, 600, 678, 550, 455, 404, 391, 373, 351};
                } else {
                    parameters = new int[]{313, 390, 444, 500, 612, 680, 579, 465, 421, 410, 373, 350};
                }
                forecastVO.setRes(parameters);
                forecastVO.setSupport("二氧化碳预测所得结果为种植适宜条件，建议维持现状并保持充足的光照");
                return R.ok().data(" forecastVO", forecastVO);

            } else if (parameter.equals("光照强度")) {
                //lux
                if (model == "线性回归") {
                    parameters = new int[]{12013, 13111, 14541, 15134, 17234, 18543, 17563, 16103, 14545, 12031};

                } else {
                    parameters = new int[]{11812, 13213, 14661, 15498, 17774, 18568, 17599, 16013, 14511, 11783};
                }
                forecastVO.setRes(parameters);
                forecastVO.setSupport("光照强度预测所得结果为种植适宜条件，建议维持现状");
                return R.ok().data(" forecastVO", forecastVO);

            } else if (parameter.equals("pm2.5")) {
                // pm2.5
                if(model == "线性回归") {
                    parameters = new int[]{68, 63, 58, 54, 50, 49, 52, 53, 68, 69,69,70,65};
                }else{
                    parameters = new int[]{67, 65, 63, 57, 54, 50, 51, 53, 59, 63,61,64,64};
                }
                forecastVO.setRes(parameters);
                forecastVO.setSupport("pm2.5预测所得结果为种植适宜条件，建议维持现状并保持通风。");
                return R.ok().data(" forecastVO", forecastVO);

            } else if (parameter.equals("pm10")) {
                //um
                if(model == "线性回归") {
                    parameters = new int[]{47, 45, 45, 40, 39, 41, 42, 43, 46, 46,47,48};
                }else{
                    parameters = new int[]{48, 46, 46, 43, 41, 40, 42, 43, 45, 46,46,47};
                }
                forecastVO.setRes(parameters);
                forecastVO.setSupport("pm10预测所得结果为种植适宜条件，建议维持现状并保持通风。");
                return R.ok().data(" forecastVO", forecastVO);

            } else if (parameter.equals("空气温度")) {
                //℃
                if(model == "线性回归"){
                    parameters = new int[]{23, 26, 26, 28, 29, 30, 29, 28, 27, 27,24,23};
                }else{
                    parameters = new int[]{22, 26, 27, 28, 30, 30, 29, 28, 27, 26,26,25};
                }
                forecastVO.setRes(parameters);
                forecastVO.setSupport("温度预测所得结果为种植适宜条件，建议维持现状,");
                return R.ok().data(" forecastVO", forecastVO);
            }else {
                //% 空气湿度
                if(model == "线性回归"){
                    parameters = new int[]{63, 57, 52, 52, 45, 46, 50, 55, 60, 67,65,71};
                }else{
                    parameters = new int[]{61, 56, 51, 53, 46, 47, 51, 55, 61, 52,66,67};
                }

                forecastVO.setRes(parameters);
                forecastVO.setSupport("空气湿度预测所得结果偏低，建议喷水提高空气湿度");
                return R.ok().data(" forecastVO", forecastVO);

            }


    }

}

