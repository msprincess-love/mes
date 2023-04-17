package com.ktg.mes.md.service.impl.dv;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktg.mes.md.constant.MesConstant;
import com.ktg.mes.md.domain.dv.DvMachineryType;
import com.ktg.mes.md.domain.md.MdItemType;
import com.ktg.mes.md.domain.md.MdVendor;
import com.ktg.mes.md.exception.IdExistNotException;
import com.ktg.mes.md.mapper.dv.DvMachineryTypeMapper;
import com.ktg.mes.md.service.IDvMachineryTypeService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/10 20:26
 * @description mes
 */
@Service
public class DvMachineryTypeServiceImpl extends ServiceImpl<DvMachineryTypeMapper, DvMachineryType> implements IDvMachineryTypeService {

    @Override
    public List<DvMachineryType> selectList(DvMachineryType dvMachineryType) {

        LambdaQueryWrapper<DvMachineryType> wrapper = new LambdaQueryWrapper<>();
        if (dvMachineryType.getMachineryTypeName() != null)
            wrapper.like(DvMachineryType::getMachineryTypeName, dvMachineryType.getMachineryTypeName());
        if (dvMachineryType.getEnableFlag() != null)
            wrapper.eq(DvMachineryType::getEnableFlag, dvMachineryType.getEnableFlag());
        return list(wrapper);
    }

    @Override
    public void add(DvMachineryType dvMachineryType) {

        LambdaQueryWrapper<DvMachineryType> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(DvMachineryType::getMachineryTypeCode, dvMachineryType.getMachineryTypeCode());
        int count = count(wrapper);
        if (count > 0)
            throw new RuntimeException("新增失败");

        StringBuilder str = new StringBuilder();
        if (dvMachineryType.getMachineryTypeCode() == null) {
            dvMachineryType.setMachineryTypeCode(MesConstant.MACHINERY_TYPE_CODE + LocalDateTime.now().toString()
                    .substring(LocalDateTime.now().toString().length() - 4));
        }
        if (dvMachineryType.getAncestors() == null) {
            DvMachineryType temp = dvMachineryType;
            while (getById(temp.getParentTypeId()) != null) {
                str.append(temp.getParentTypeId()).append(",");
                temp = getById(temp.getParentTypeId());
            }
            str.append(0);
            dvMachineryType.setAncestors(str.toString());
        }
        save(dvMachineryType);
    }

    @Override
    public DvMachineryType selectById(Long id) {
        DvMachineryType dv = getById(id);
        if (dv == null)
            throw new IdExistNotException("查不存在");
        return dv;
    }

    @Override
    public void edit(DvMachineryType dvMachineryType) {
        updateById(dvMachineryType);
    }

    @Override
    public void deleteById(Long id) {
        if (getById(id) == null) {
            throw new IdExistNotException(id.toString());
        }
        if (selectChildren(id) != null && selectChildren(id).size() > 0) {
            throw new RuntimeException("存在孩子，不能删除");
        }
        removeById(id);
    }

    public List<DvMachineryType> selectChildren(Long typeId) {
        LambdaQueryWrapper<DvMachineryType> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(DvMachineryType::getParentTypeId, typeId);
        return list(wrapper);
    }
}
