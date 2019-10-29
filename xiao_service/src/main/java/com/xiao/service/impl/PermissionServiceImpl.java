package com.xiao.service.impl;


import com.xiao.dao.IPermissionDao;
import com.xiao.domain.Permission;
import com.xiao.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao permissionDao;

    public List<Permission> findAll() throws Exception {
        return permissionDao.findAll();
    }

    public void save(Permission permission) {
        permissionDao.save(permission);
    }
}
