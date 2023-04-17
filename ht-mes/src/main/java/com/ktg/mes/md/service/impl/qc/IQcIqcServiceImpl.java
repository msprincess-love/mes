package com.ktg.mes.md.service.impl.qc;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktg.mes.md.domain.qc.QcIqc;
import com.ktg.mes.md.domain.wm.WmWarehouse;
import com.ktg.mes.md.exception.IdExistNotException;
import com.ktg.mes.md.mapper.qc.QcIqcMapper;
import com.ktg.mes.md.service.IQcIqcService;
import org.springframework.stereotype.Service;

@Service
public class IQcIqcServiceImpl extends ServiceImpl<QcIqcMapper, QcIqc> implements IQcIqcService {
    @Override
    public Page<QcIqc> getList(int pageNum, int pageSize, QcIqc qcIqc) {
        Page<QcIqc> pageInfo = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<QcIqc> wrapper = new LambdaQueryWrapper<>();
        if (qcIqc.getIqcCode() != null)
            wrapper.eq(QcIqc::getIqcCode, qcIqc.getIqcCode());
        if (qcIqc.getVendorCode() != null)
            wrapper.eq(QcIqc::getVendorCode, qcIqc.getVendorCode());
        if (qcIqc.getVendorName() != null)
            wrapper.like(QcIqc::getVendorName, qcIqc.getVendorName());
        if (qcIqc.getItemCode() != null)
            wrapper.eq(QcIqc::getItemCode, qcIqc.getItemCode());
        if (qcIqc.getItemName() != null)
            wrapper.like(QcIqc::getItemName, qcIqc.getItemName());
        if (qcIqc.getInspector() != null)
            wrapper.like(QcIqc::getInspector, qcIqc.getInspector());
        return page(pageInfo, wrapper);
    }

    @Override
    public void add(QcIqc qcIqc) {
        LambdaQueryWrapper<QcIqc> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(QcIqc::getIqcCode, qcIqc.getIqcCode());
        int count = count(wrapper);
        if (count > 0)
            throw new RuntimeException("新增失败");
        save(qcIqc);
    }

    @Override
    public void deleteById(Long id) {
        QcIqc qcIqc = getById(id);
        if (qcIqc == null)
            throw new IdExistNotException("qcIqc不存在");
        removeById(id);
    }

    @Override
    public QcIqc selectById(Long id) {
        QcIqc qcIqc = getById(id);
        if (qcIqc == null)
            throw new IdExistNotException("qcIqc不存在");
        return qcIqc;
    }

    @Override
    public void edit(QcIqc qcIqc) {
        updateById(qcIqc);
    }
}
