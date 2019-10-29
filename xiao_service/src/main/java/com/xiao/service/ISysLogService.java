package com.xiao.service;


import com.xiao.domain.SysLog;

import java.util.List;

public interface ISysLogService {

    void save(SysLog sysLog)throws Exception;

    List<SysLog> findAll();
}
