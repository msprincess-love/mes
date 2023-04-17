package com.ktg.mes.md.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ktg.mes.md.domain.md.MdItemType;
import com.ktg.mes.md.vo.MdItemTypeVo;

import java.util.List;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/7 8:28
 * @description mes
 */
public interface IMdItemTypeService extends IService<MdItemType> {
    List<MdItemType> selectItemTypeList(MdItemType mdItemType);

    void add(MdItemType mdItemType);

    MdItemType selectItemTypeById(Long typeId);

    void deleteById(Long typeId);

    List<MdItemType> selectChildren(Long typeId);

    void edit(MdItemType mdItemType);

    List<MdItemTypeVo> treeSelect();


}
