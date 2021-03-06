package com.xiao.service;


import com.xiao.domain.Role;
import com.xiao.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    List<UserInfo> findAll()throws Exception;

    void save(UserInfo userInfo)throws Exception;

    UserInfo findById(String id)throws Exception;

    List<Role> findOtherRole(String userId);

    void addRoleToUser(String userId, String[] roleIds);
}
