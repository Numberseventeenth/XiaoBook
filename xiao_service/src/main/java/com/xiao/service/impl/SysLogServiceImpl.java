package com.xiao.service.impl;


import com.xiao.dao.ISysLogDao;
import com.xiao.domain.SysLog;
import com.xiao.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    private ISysLogDao sysLogDao;

    public void save(SysLog sysLog) throws Exception {
        sysLogDao.save(sysLog);
    }

    public List<SysLog> findAll() {
        return sysLogDao.findAll();
    }
}
