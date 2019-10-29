package com.xiao.controller;


import com.xiao.domain.SysLog;
import com.xiao.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private ISysLogService sysLogService;

    @RequestMapping("/findAll.do")
    public ModelAndView sysLog(){
        ModelAndView mv = new ModelAndView();
        List<SysLog> list = sysLogService.findAll();
        mv.addObject("sysLogs",list);
        mv.setViewName("syslog-list");
        return mv;
    }
}
