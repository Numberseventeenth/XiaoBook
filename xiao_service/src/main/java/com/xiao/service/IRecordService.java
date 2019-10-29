package com.xiao.service;

import com.xiao.domain.Record;

import java.util.List;

public interface IRecordService {

    void save(Record record);

    List<Record> findById(Integer id);
}
