package com.xiao.service.impl;


import com.xiao.dao.IRoleDao;
import com.xiao.domain.Permission;
import com.xiao.domain.Role;
import com.xiao.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }

    public void save(Role role) {
        roleDao.save(role);
    }

    public Role findById(String roleId) {
        return roleDao.findById(roleId);
    }

    public List<Permission> findOtherPermission(String roleId) {
        return roleDao.findOtherPermission(roleId);
    }

    public void addPermissionToRole(String roleId, String[] permissionIds) {
        for (String permissionId : permissionIds) {
            roleDao.addPermissionToRole(roleId,permissionId);
        }
    }

}
