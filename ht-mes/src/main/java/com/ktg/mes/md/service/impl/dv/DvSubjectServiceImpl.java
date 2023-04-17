package com.ktg.mes.md.service.impl.dv;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktg.mes.md.domain.dv.DvSubject;
import com.ktg.mes.md.exception.IdExistNotException;
import com.ktg.mes.md.mapper.dv.DvSubjectMapper;
import com.ktg.mes.md.service.IDvSubjectService;
import org.springframework.stereotype.Service;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/11 11:40
 * @description mes
 */
@Service
public class DvSubjectServiceImpl extends ServiceImpl<DvSubjectMapper, DvSubject> implements IDvSubjectService {

    @Override
    public Page<DvSubject> selectList(DvSubject dvSubject, int pageNum, int pageSize) {

        Page<DvSubject> pageInfo = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<DvSubject> wrapper = new LambdaQueryWrapper<>();
        if (dvSubject.getSubjectCode() != null)
            wrapper.eq(DvSubject::getSubjectCode, dvSubject.getSubjectCode());
        if (dvSubject.getSubjectName() != null)
            wrapper.like(DvSubject::getSubjectName, dvSubject.getSubjectName());
        if (dvSubject.getSubjectType() != null)
            wrapper.eq(DvSubject::getSubjectType, dvSubject.getSubjectType());
        return page(pageInfo, wrapper);
    }

    @Override
    public void add(DvSubject dvSubject) {
        LambdaQueryWrapper<DvSubject> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(DvSubject::getSubjectCode, dvSubject.getSubjectCode());
        int count = count(wrapper);
        if (count > 0)
            throw new RuntimeException("新增失败");
        save(dvSubject);
    }

    @Override
    public DvSubject selectById(Long id) {
        DvSubject dv = getById(id);
        if (dv == null)
            throw new IdExistNotException("不存在");
        return dv;
    }

    @Override
    public void edit(DvSubject dvSubject) {
        updateById(dvSubject);
    }

    @Override
    public void deleteById(Long id) {
        DvSubject dvSubject = getById(id);
        if (dvSubject == null)
            throw new IdExistNotException("查不存在");
        removeById(id);
    }
}
