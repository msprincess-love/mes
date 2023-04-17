package com.ktg.mes.md.service.impl.md;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktg.mes.md.domain.md.MdVendor;
import com.ktg.mes.md.exception.IdExistNotException;
import com.ktg.mes.md.mapper.md.MdVendorMapper;
import com.ktg.mes.md.service.IMdVendorService;
import org.springframework.stereotype.Service;

@Service
public class MdVendorServiceImpl extends ServiceImpl<MdVendorMapper, MdVendor> implements IMdVendorService {

    @Override
    public Page<MdVendor> selectVendorList(MdVendor vendor, int pageNum, int pageSize) {
        Page<MdVendor> pageInfo = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<MdVendor> wrapper = new LambdaQueryWrapper<>();
        if (vendor.getVendorCode() != null)
            wrapper.eq(MdVendor::getVendorCode, vendor.getVendorCode());
        if (vendor.getVendorName() != null)
            wrapper.like(MdVendor::getVendorName, vendor.getVendorName());
        if (vendor.getVendorEn() != null)
            wrapper.like(MdVendor::getVendorEn, vendor.getVendorEn());
        if (vendor.getEnableFlag() != null)
            wrapper.eq(MdVendor::getEnableFlag, vendor.getEnableFlag());
        return page(pageInfo, wrapper);
    }

    @Override
    public void add(MdVendor vendor) {
        LambdaQueryWrapper<MdVendor> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(MdVendor::getVendorCode, vendor.getVendorCode());
        int count = count(wrapper);
        if (count > 0)
            throw new RuntimeException("新增失败");
        save(vendor);
    }

    @Override
    public void deleteById(Long id) {
        if (getById(id) == null)
            throw new IdExistNotException();
        removeById(id);
    }

    @Override
    public MdVendor selectById(Long id) {
        MdVendor vendor = getById(id);
        if (vendor == null)
            throw new IdExistNotException();
        return vendor;
    }

    @Override
    public void edit(MdVendor vendor) {
        updateById(vendor);
    }
}
