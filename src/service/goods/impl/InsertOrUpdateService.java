package service.goods.impl;

import dao.goods.IInsertOrUpdateDao;
import model.TbShangpin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.goods.IInsertOrUpdateService;

/*
 *   #auther:李琪
 *   #date: 2019/12/21
 *   #description
 */
@Service
public class InsertOrUpdateService implements IInsertOrUpdateService {
    IInsertOrUpdateDao insertOrUpdateDao;
    @Autowired
    public void setInsertOrUpdateDao(IInsertOrUpdateDao insertOrUpdateDao) {
        this.insertOrUpdateDao = insertOrUpdateDao;
    }

    @Override
    public int insertOrUpdate(TbShangpin tbShangpin) {
        insertOrUpdateDao.InsertOrUpdate(tbShangpin);
        return 0;
    }
}
