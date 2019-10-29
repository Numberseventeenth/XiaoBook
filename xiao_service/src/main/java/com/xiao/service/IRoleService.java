package com.xiao.service;



import com.xiao.domain.Permission;
import com.xiao.domain.Role;

import java.util.List;

public interface IRoleService {

    List<Role> findAll()throws Exception;

    void save(Role role);

    Role findById(String roleId);

    List<Permission> findOtherPermission(String roleId);

    void addPermissionToRole(String roleId, String[] permissionIds);
}
