package com.ktg.mes.md.service.impl.dv;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktg.mes.md.domain.dv.DvCheckPlan;
import com.ktg.mes.md.domain.dv.DvCheckSubject;
import com.ktg.mes.md.exception.IdExistNotException;
import com.ktg.mes.md.mapper.dv.DvCheckPlanMapper;
import com.ktg.mes.md.mapper.dv.DvCheckSubjectMapper;
import com.ktg.mes.md.service.IDvCheckPlanService;
import com.ktg.mes.md.service.IDvCheckSubjectService;
import org.springframework.stereotype.Service;


/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/11 11:40
 * @description mes
 */
@Service
public class DvCheckSubjectServiceImpl extends ServiceImpl<DvCheckSubjectMapper, DvCheckSubject> implements IDvCheckSubjectService {

    @Override
    public Page<DvCheckSubject> selectList(Long planId, int pageNum, int pageSize) {

        Page<DvCheckSubject> pageInfo = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<DvCheckSubject> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(DvCheckSubject::getPlanId, planId);
        return page(pageInfo, wrapper);
    }

    @Override
    public void add(DvCheckSubject dvCheckSubject) {
        save(dvCheckSubject);
    }


    @Override
    public void deleteById(Long id) {
        DvCheckSubject dvCheckSubject = getById(id);
        if (dvCheckSubject == null)
            throw new IdExistNotException("查不存在");
        removeById(id);
    }

}
