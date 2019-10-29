package com.xiao.service.impl;

import com.github.pagehelper.PageHelper;
import com.xiao.dao.IShopDao;
import com.xiao.domain.Shop;
import com.xiao.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("shopService")
@Transactional
public class ShopServiceImpl implements IShopService {

    @Autowired
    private IShopDao shopDao;

    @Override
    public void save(Shop shop) {
        shopDao.save(shop);
    }

    @Override
    public List<Shop> findAll(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        return shopDao.findAll();
    }

    @Override
    public List<Shop> findAll() {
        return shopDao.findAll();
    }

    @Override
    public Shop findById(Integer id) {
        return shopDao.findByIdWithMember(id);
    }

    @Override
    public void update(Shop shop) {
        shopDao.update(shop);
    }

    @Override
    public List<Shop> query(Integer id, String value) {
        /*<option value="1">店铺名称</option>
        <option value="2">联系电话</option>
        <option value="0">ID</option>
        <option value="3">店铺优惠</option>
        <option value="4">编号</option>*/
        List<Shop> shops = null;
        if(id == 1){
            shops = shopDao.findByName("%"+value+"%");
        }else if (id == 2){
            shops = shopDao.findByTel("%"+value+"%");
        }else if (id == 0){
            int valueId = Integer.parseInt(value);
            shops = shopDao.findById(valueId);
        }else if (id == 3){
            shops = shopDao.findByDiscounts("%"+value+"%");
        }else if (id == 4){
            shops = shopDao.findByNumber("%"+value+"%");
        }
        return null;
    }
}
