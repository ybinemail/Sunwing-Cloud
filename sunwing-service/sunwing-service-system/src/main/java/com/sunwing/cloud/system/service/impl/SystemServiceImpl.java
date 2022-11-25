package com.sunwing.cloud.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sunwing.cloud.system.entity.SystemTable;
import com.sunwing.cloud.system.mapper.SystemTableMapper;
import com.sunwing.cloud.system.service.ISystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemServiceImpl implements ISystemService {
    @Autowired
    SystemTableMapper systemTableMapper;

    @Override
    public List<SystemTable> list() {
        return systemTableMapper.list();
    }

    @Override
    public Page<SystemTable> page() {
        Page<SystemTable> page = new Page<>(1, 10);
        List<SystemTable> records = systemTableMapper.page(page);
        page.setRecords(records);
        return page;
    }
}
