package com.xiao.service;


import com.xiao.domain.Permission;

import java.util.List;

public interface IPermissionService {

    List<Permission> findAll()throws Exception;

    void save(Permission permission);
}
