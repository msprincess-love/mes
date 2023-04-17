package com.ktg.mes.md.mapper.md;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ktg.mes.md.domain.md.MdItemType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/7 8:59
 * @description mes
 */
@Mapper
public interface MdItemTypeMapper extends BaseMapper<MdItemType> {

    List<MdItemType> selectItemTypeList(MdItemType mdItemType);

    void add(MdItemType mdItemType);

    MdItemType selectItemTypeById(@Param("typeId") Long typeId);

    void removeById(@Param("typeId") Long typeId);

    List<MdItemType> selectChildren(@Param("typeId") Long typeId);

    void edit(MdItemType mdItemType);

    List<MdItemType> listPage(@Param("offset") int offset, @Param("pageSize") int pageSize);

}
