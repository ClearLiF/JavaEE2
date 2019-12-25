package service.goods.impl;

import dao.goods.IGetAllGoods;
import model.TbShangpin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.goods.IGetAllGoodsService;

import java.util.ArrayList;

/*
 *   #auther:李琪
 *   #date: 2019/12/21
 *   #description
 */
@Service
public class GetAllGoodsService implements IGetAllGoodsService {
    IGetAllGoods getAllGoods;
    @Autowired
    public void setGetAllGoods(IGetAllGoods getAllGoods) {
        this.getAllGoods = getAllGoods;
    }

    @Override
    public ArrayList<TbShangpin> getAllGoods() {

        return   getAllGoods.getGoods();
    }
}
