package com.ktg.system.mapper;

import com.ktg.common.core.domain.entity.SysAutoCodeRule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper

public interface SysAutoCodeRuleMapper {

    public List<SysAutoCodeRule> selectSysAutoCodeResultList(SysAutoCodeRule sysAutoCodeRule);

    public SysAutoCodeRule findById(Long ruleId);

    public int add(SysAutoCodeRule sysAutoCodeRule);

    public int updateSysAutoCodeRule(SysAutoCodeRule sysAutoCodeRule);

    public int deleteById(Long ruleId);

    public SysAutoCodeRule checkRuleCodeUnique(String ruleCode);

    public SysAutoCodeRule checkRuleNameUnique(String ruleName);
}
