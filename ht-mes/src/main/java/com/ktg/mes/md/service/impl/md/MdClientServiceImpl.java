package com.ktg.mes.md.service.impl.md;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktg.mes.md.domain.md.MdClient;
import com.ktg.mes.md.exception.IdExistNotException;
import com.ktg.mes.md.mapper.md.MdClientMapper;
import com.ktg.mes.md.service.IMdClientService;
import org.springframework.stereotype.Service;

@Service
public class MdClientServiceImpl extends ServiceImpl<MdClientMapper, MdClient> implements IMdClientService {

    @Override
    public Page<MdClient> selectClientList(MdClient client, int pageNum, int pageSize) {
        Page<MdClient> pageInfo = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<MdClient> wrapper = new LambdaQueryWrapper<>();
        if (client.getClientCode() != null)
            wrapper.eq(MdClient::getClientCode, client.getClientCode());
        if (client.getClientName() != null)
            wrapper.like(MdClient::getClientName, client.getClientName());
        if (client.getClientEn() != null)
            wrapper.like(MdClient::getClientEn, client.getClientEn());
        if (client.getEnableFlag() != null)
            wrapper.eq(MdClient::getEnableFlag, client.getEnableFlag());
        return page(pageInfo, wrapper);
    }

    @Override
    public MdClient selectById(Long id) {
        MdClient client = getById(id);
        if (client == null)
            throw new IdExistNotException("用户不存在");
        return client;
    }

    @Override
    public void edit(MdClient client) {
        updateById(client);
    }

    @Override
    public void add(MdClient client) {
        LambdaQueryWrapper<MdClient> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(MdClient::getClientCode, client.getClientCode());
        int count = count(wrapper);
        if (count > 0)
            throw new RuntimeException("新增失败");
        save(client);
    }

    @Override
    public void deleteById(Long id) {
        MdClient client = getById(id);
        if (client == null)
            throw new IdExistNotException("用户不存在");
        removeById(id);
    }
}
