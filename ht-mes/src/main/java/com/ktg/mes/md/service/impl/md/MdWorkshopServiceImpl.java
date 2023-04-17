package com.ktg.mes.md.service.impl.md;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktg.mes.md.domain.md.MdWorkshop;
import com.ktg.mes.md.exception.IdExistNotException;
import com.ktg.mes.md.mapper.md.MdWorkshopMapper;
import com.ktg.mes.md.service.IMdWorkshopService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/9 17:10
 * @description mes
 */
@Service
public class MdWorkshopServiceImpl extends ServiceImpl<MdWorkshopMapper, MdWorkshop> implements IMdWorkshopService {
    @Override
    public Page<MdWorkshop> selectList(MdWorkshop workshop, int pageNum, int pageSize) {
        Page<MdWorkshop> pageInfo = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<MdWorkshop> wrapper = new LambdaQueryWrapper<>();
        if (workshop.getWorkshopCode() != null)
            wrapper.eq(MdWorkshop::getWorkshopCode, workshop.getWorkshopCode());
        if (workshop.getWorkshopName() != null)
            wrapper.like(MdWorkshop::getWorkshopName, workshop.getWorkshopName());
        return page(pageInfo, wrapper);
    }

    @Override
    public void add(MdWorkshop workshop) {
        LambdaQueryWrapper<MdWorkshop> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(MdWorkshop::getWorkshopCode, workshop.getWorkshopCode());
        int count = count(wrapper);
        if (count > 0)
            throw new RuntimeException("新增失败，此车间已存在");
        save(workshop);
    }

    @Override
    public void deleteById(Long id) {
        MdWorkshop workshop = getById(id);
        if (workshop == null)
            throw new IdExistNotException("工作站不存在");
        removeById(id);
    }

    @Override
    public MdWorkshop selectById(Long id) {
        MdWorkshop workshop = getById(id);
        if (workshop == null)
            throw new IdExistNotException("工作站不存在");
        return workshop;
    }

    @Override
    public void edit(MdWorkshop workshop) {
        updateById(workshop);
    }

    @Override
    public List<MdWorkshop> listAll() {
        List<MdWorkshop> workshops = list();
        if (workshops.size() > 0)
            return workshops;
        throw new RuntimeException("暂没有车间数据");
    }
}
