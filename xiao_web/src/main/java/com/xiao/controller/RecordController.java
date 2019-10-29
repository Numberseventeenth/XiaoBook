package com.xiao.controller;

import com.xiao.domain.Record;
import com.xiao.service.IRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/record")
public class RecordController {

    @Autowired
    private IRecordService recordService;

    @RequestMapping("/save.do")
    public String save(Record record)throws Exception{
        System.out.println("进入了");
        System.out.println(record);
        recordService.save(record);
        return null;
    }

}
