package service.goods.impl;

import dao.goods.IDeleteGoodDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.goods.IDeleteGoodService;

/*
 *   #auther:李琪
 *   #date: 2019/12/21
 *   #description
 */
@Service
public class DeleteGoodService implements IDeleteGoodService {
    IDeleteGoodDao deleteGoodDao;
    @Autowired
    public void setDeleteGoodDao(IDeleteGoodDao deleteGoodDao) {
        this.deleteGoodDao = deleteGoodDao;
    }

    @Override
    public int deleteService(int id) {
        deleteGoodDao.deleteGood(id);
        return 0;
    }
}
