package com.orange.boot.dev1.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orange.boot.dev1.entity.Effect;
import com.orange.boot.dev1.mapper.EffectMapper;
import com.orange.boot.dev1.service.EffectService;
import com.orange.boot.utils.IpAndPortUtil;
import com.orange.boot.utils.R;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author CZF
 * @since 2022-06-01
 */
@Service
public class EffectServiceImpl extends ServiceImpl<EffectMapper, Effect> implements EffectService {

    @Value("${uploadPath}")
    String uploadPath;

    @Override
    public R listPage(Long current, Integer limit, String like) {

        Page<Effect> page = new Page<>(current,limit);

        QueryWrapper<Effect> wrapper = new QueryWrapper<>();

        //动态模糊查询
        if (like != null) {
            wrapper.like("name", like);
        }

        Page<Effect> returnPage = baseMapper.selectPage(page, wrapper);

        long total = returnPage.getTotal();  //总记录数
        List<Effect> effects = returnPage.getRecords();

        return R.ok().data("total",total).data("rows",effects);
    }

    @Override
    public R addEffect(String name, String effectDetails, MultipartFile pic) {
        if (pic != null) {
            String fileName = System.currentTimeMillis() + pic.getOriginalFilename();

            System.out.println(uploadPath);

            //第一次运行的时候，这个文件所在的目录往往是不存在的，这里需要创建一下目录
            File dir = new File(uploadPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            //把浏览器上传的文件复制到希望的位置
            File targetFile = new File(uploadPath, fileName);
            try {
                pic.transferTo(targetFile);
            } catch (IOException e) {
                e.printStackTrace();
                return R.error().message("上传图片失败");
            }

            //服务器的ip和端口号
            String ipAndPort = IpAndPortUtil.getIpAndPort();
            String picUrl = "http://" + ipAndPort + "/news/" + fileName;

            Effect effect = new Effect();
            effect.setName(name);
            effect.setEffectDetails(effectDetails);
            effect.setImg(picUrl);
            baseMapper.insert(effect);

            return R.ok();

        } else {
            return R.error().message("上传的文件为空！");
        }

    }
}
