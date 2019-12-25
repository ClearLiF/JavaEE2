package service.userService.impl;

import dao.userDao.IDongJieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.userService.IDongJieService;

/*
 *   #auther:李琪
 *   #date: 2019/12/21
 *   #description
 */
@Service
public class DongJieService implements IDongJieService {

    IDongJieDao dongJieDao;
    @Autowired
    public void setDongJieDao(IDongJieDao dongJieDao) {
        this.dongJieDao = dongJieDao;
    }

    @Override
    public int dongJie(int id, int type) {
        //执行冻结方法
        dongJieDao.dongJie(id,type);
        return 0;
    }
}
