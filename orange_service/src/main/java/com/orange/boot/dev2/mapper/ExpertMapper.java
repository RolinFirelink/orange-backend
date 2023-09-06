package com.orange.boot.dev2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.orange.boot.dev2.entity.Expert;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author LZH
 * @since 2022-06-14
 */
public interface ExpertMapper extends BaseMapper<Expert> {


    @Select({
            "SELECT  expert_id,expert_name,expert_phone,expert_photo,expert_introduction,expert_honor,"
                    +" expert_territory,wx,title,year,answer_number,be_asked_number FROM expert where is_deleted = 0 "
    })
    Page<Expert> getExpertList(Page<Expert> page);


}
