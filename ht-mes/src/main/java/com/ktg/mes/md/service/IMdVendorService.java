package com.ktg.mes.md.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ktg.mes.md.domain.md.MdVendor;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/7 8:28
 * @description mes
 */
public interface IMdVendorService extends IService<MdVendor> {


    Page<MdVendor> selectVendorList(MdVendor vendor, int pageNum, int pageSize);

    void add(MdVendor vendor);

    void deleteById(Long id);

    MdVendor selectById(Long id);

    void edit(MdVendor vendor);

}
