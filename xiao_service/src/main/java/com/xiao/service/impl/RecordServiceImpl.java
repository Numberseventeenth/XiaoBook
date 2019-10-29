package com.xiao.service.impl;

import com.xiao.dao.IRecordDao;
import com.xiao.domain.Record;
import com.xiao.service.IRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("recordService")
@Transactional
public class RecordServiceImpl implements IRecordService {

    @Autowired
    private IRecordDao recordDao;

    @Override
    public void save(Record record) {
        Date date = new Date();
        record.setR_date(date);
        recordDao.save(record);
    }

    @Override
    public List<Record> findById(Integer id) {
        return recordDao.findById(id);
    }
}
