package com.ktg.system.mapper;

import com.ktg.common.core.domain.entity.SysAutoCodeResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper

public interface SysAutoCodeResultMapper {
    public List<SysAutoCodeResult> selectSysAutoCodeResultList(SysAutoCodeResult sysAutoCodeResult);

    public void add(SysAutoCodeResult sysAutoCodeResult);

    public void updateAutoCodeResult(SysAutoCodeResult sysAutoCodeResult);

    public void deleteById(Long codeId);


}
