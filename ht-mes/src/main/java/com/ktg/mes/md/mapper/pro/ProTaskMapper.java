package com.ktg.mes.md.mapper.pro;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ktg.mes.md.domain.pro.ProProcess;
import com.ktg.mes.md.domain.pro.ProTask;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/9 19:51
 * @description mes
 */
@Mapper
public interface ProTaskMapper extends BaseMapper<ProTask> {
}
