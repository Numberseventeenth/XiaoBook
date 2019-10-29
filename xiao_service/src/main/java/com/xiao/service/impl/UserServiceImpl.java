package com.xiao.service.impl;


import com.xiao.dao.IUserDao;
import com.xiao.domain.Role;
import com.xiao.domain.UserInfo;
import com.xiao.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {
    //tom 123
    //fox 321
    //james 456

    @Autowired
    private IUserDao userDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo = userDao.findByUserName(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        User user = new User(userInfo.getUsername(),"{noop}" + userInfo.getPassword(),getAuthority(userInfo.getRoles()));
        User user = new User(userInfo.getUsername(), userInfo.getPassword(),userInfo.getStatus()==0?false:true, true,true,true,getAuthority(userInfo.getRoles()));
        return user;


    }

    //集合中装入的是权限集合
    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));

        }
        return list;
    }

    public List<UserInfo> findAll() throws Exception {
        return userDao.findAll();
    }

    public void save(UserInfo userInfo) throws Exception {
        //加密处理
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userDao.save(userInfo);
    }

    public UserInfo findById(String id) throws Exception {
        return userDao.findById(id);
    }

    public List<Role> findOtherRole(String userId) {
        return userDao.findOtherRoles(userId);
    }

    public void addRoleToUser(String userId, String[] roleIds) {
        for (String roleId : roleIds) {
            userDao.addRoleToUser(userId,roleId);
        }
    }
}
