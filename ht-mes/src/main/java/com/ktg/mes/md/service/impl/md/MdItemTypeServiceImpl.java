package com.ktg.mes.md.service.impl.md;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktg.mes.md.domain.md.MdItemType;
import com.ktg.mes.md.exception.IdExistNotException;
import com.ktg.mes.md.mapper.md.MdItemTypeMapper;
import com.ktg.mes.md.service.IMdItemTypeService;
import com.ktg.mes.md.vo.MdItemTypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/7 9:00
 * @description mes
 */
@Service
public class MdItemTypeServiceImpl extends ServiceImpl<MdItemTypeMapper, MdItemType> implements IMdItemTypeService {
    @Autowired
    private MdItemTypeMapper mdItemTypeMapper;

    @Override
    public List<MdItemType> selectItemTypeList(MdItemType mdItemType) {
        return mdItemTypeMapper.selectItemTypeList(mdItemType);
    }

    @Override
    public void add(MdItemType mdItemType) {
        StringBuilder str = new StringBuilder();
        if (mdItemType.getItemTypeCode() == null) {
            mdItemType.setItemTypeCode(UUID.randomUUID().toString());
        }
        if (mdItemType.getAncestors() == null) {
            MdItemType temp = mdItemType;
            while (selectItemTypeById(temp.getParentTypeId()) != null) {
                str.append(temp.getParentTypeId()).append(",");
                log.debug(selectItemTypeById(temp.getParentTypeId()).toString());
                temp = selectItemTypeById(temp.getParentTypeId());
            }
            str.append(0);
            mdItemType.setAncestors(str.toString());
        }
        mdItemTypeMapper.add(mdItemType);
    }

    @Override
    public MdItemType selectItemTypeById(Long typeId) {
        return mdItemTypeMapper.selectItemTypeById(typeId);
    }

    @Override
    public void deleteById(Long typeId) {
        if (selectItemTypeById(typeId) == null) {
            throw new IdExistNotException(typeId.toString());
        }
        if (selectChildren(typeId) != null && selectChildren(typeId).size() > 0) {
            throw new RuntimeException("存在孩子，不能删除");
        }
        mdItemTypeMapper.removeById(typeId);
    }

    @Override
    public List<MdItemType> selectChildren(Long typeId) {
        return mdItemTypeMapper.selectChildren(typeId);
    }

    @Override
    public void edit(MdItemType mdItemType) {
        mdItemTypeMapper.edit(mdItemType);
    }

    @Override
    public List<MdItemTypeVo> treeSelect() {
        return getTreeByParentId(0L);
    }

    public List<MdItemTypeVo> getTreeByParentId(Long parentTypeId) {
        List<MdItemTypeVo> result = new ArrayList<>();
        List<MdItemType> mdItemTypes = mdItemTypeMapper.selectChildren(parentTypeId);
        if (mdItemTypes != null && mdItemTypes.size() > 0) {
            for (MdItemType mdItemType : mdItemTypes) {
                MdItemTypeVo mdItemTypeVo = new MdItemTypeVo();
                mdItemTypeVo.setId(mdItemType.getItemTypeId());
                mdItemTypeVo.setLabel(mdItemType.getItemTypeName());
                mdItemTypeVo.setChildren(getTreeByParentId(mdItemType.getItemTypeId()));
                result.add(mdItemTypeVo);
            }
        }
        return result;
    }

}
