package service.goods.impl;

import dao.goods.ISearchGoodDao;
import model.TbShangpin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.goods.ISearchGoodService;

import java.util.ArrayList;

/*
 *   #auther:李琪
 *   #date: 2019/12/21
 *   #description
 */
@Service
public class SearchGoodService implements ISearchGoodService {
    ISearchGoodDao searchGoodDao;
    @Autowired
    public void setSearchGoodDao(ISearchGoodDao searchGoodDao) {
        this.searchGoodDao = searchGoodDao;
    }

    @Override
    public ArrayList<TbShangpin> searchGood(String name) {

        return searchGoodDao.searchGood(name);
    }

    @Override
    public ArrayList<TbShangpin> searchGoodByType(int type1, int type2) {

        return searchGoodDao.searchGoodUseType(type1,type2);
    }
}
