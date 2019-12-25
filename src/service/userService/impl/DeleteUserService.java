package service.userService.impl;

import dao.userDao.IDeleteUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.userService.IDeleteUserService;

/*
 *   #auther:李琪
 *   #date: 2019/12/20
 *   #description
 */
@Service
public class DeleteUserService implements IDeleteUserService {
    IDeleteUserDao deleteUserDao;
    @Autowired
    public void setDeleteUserDao(IDeleteUserDao deleteUserDao) {
        this.deleteUserDao = deleteUserDao;
    }

    @Override
    public int deleteUser(int id) {
        //删除指定id的dao
        deleteUserDao.deleteUserDao(id);
        return 0;
    }
}
