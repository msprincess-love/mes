package com.ktg.mes.md.mapper.wm;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ktg.mes.md.domain.wm.WmItemRecpt;
import com.ktg.mes.md.domain.wm.WmItemRecptLine;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/14 9:12
 * @description mes
 */
@Mapper
public interface WmItemRecptLineMapper extends BaseMapper<WmItemRecptLine> {
}
