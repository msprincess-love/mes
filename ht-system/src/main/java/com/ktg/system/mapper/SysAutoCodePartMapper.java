package com.ktg.system.mapper;

import com.ktg.common.core.domain.entity.SysAutoCodePart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysAutoCodePartMapper {
    public List<SysAutoCodePart> selectSysAutoCodePartList(SysAutoCodePart sysAutoCodePart);

    public SysAutoCodePart findById(Long partId);

    public SysAutoCodePart checkPartUnique(SysAutoCodePart sysAutoCodePart);

    public int add(SysAutoCodePart sysAutoCodePart);

    public int updateSysAutoCodePart(SysAutoCodePart sysAutoCodePart);

    public int deleteById(Long partId);
}
