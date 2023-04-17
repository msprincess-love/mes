package com.ktg.mes.md.service.impl.dv;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktg.mes.md.domain.dv.DvRepairLine;
import com.ktg.mes.md.domain.dv.DvSubject;
import com.ktg.mes.md.mapper.dv.DvRepairLineMapper;
import com.ktg.mes.md.service.IDvRepairLineService;
import com.ktg.mes.md.service.IDvSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/16 13:55
 * @description mes
 */
@Service
public class DvRepairLineServiceImpl extends ServiceImpl<DvRepairLineMapper, DvRepairLine> implements IDvRepairLineService {

    @Autowired
    private IDvSubjectService dvSubjectService;


    @Override
    public Page<DvRepairLine> selectList(int pageNum, int pageSize) {
        Page<DvRepairLine> pageInfo = new Page<>(pageNum, pageSize);
        return page(pageInfo);
    }

    @Override
    public void add(DvRepairLine dvRepairLine) {
        if (dvRepairLine.getSubjectName() == null) {
            throw new RuntimeException("项目名称最好不要为空哦");
        }
        LambdaQueryWrapper<DvSubject> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(DvSubject::getSubjectName, dvRepairLine.getSubjectName());
        DvSubject dvSubject = dvSubjectService.getOne(wrapper);
        dvRepairLine.setSubjectCode(dvSubject.getSubjectCode());
        dvRepairLine.setSubjectId(dvSubject.getSubjectId());
        dvRepairLine.setSubjectContent(dvSubject.getSubjectContent());
    }

    @Override
    public DvRepairLine selectById(Long id) {
        return getById(id);
    }

    @Override
    public void edit(DvRepairLine dvRepairLine) {
        updateById(dvRepairLine);
    }

    @Override
    public void deleteById(Long id) {
        removeById(id);
    }
}
