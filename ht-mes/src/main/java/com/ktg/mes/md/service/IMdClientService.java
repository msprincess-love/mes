package com.ktg.mes.md.service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ktg.mes.md.domain.md.MdClient;

public interface IMdClientService extends IService<MdClient> {

    void add(MdClient client);

    void deleteById(Long id);


    Page<MdClient> selectClientList(MdClient client, int pageNum, int pageSize);

    MdClient selectById(Long id);

    void edit(MdClient client);

}
