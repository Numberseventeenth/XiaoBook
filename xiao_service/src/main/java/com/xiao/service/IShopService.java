package com.xiao.service;

import com.xiao.domain.Member;
import com.xiao.domain.Shop;

import java.util.List;

public interface IShopService {
    void save(Shop shop);

    List<Shop> findAll(Integer page, Integer size);

    List<Shop> findAll();

    Shop findById(Integer id);

    void update(Shop shop);

    List<Shop> query(Integer id, String value);
}
