package service.userService.impl;

import dao.userDao.IGetUserDao;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.userService.IGetUserService;

import java.util.ArrayList;

/*
 *   #auther:李琪
 *   #date: 2019/12/20
 *   #description
 */
@Service
public class GetUserService implements IGetUserService {

    IGetUserDao getUserDao;
    @Autowired
    public void setGetUserDao(IGetUserDao getUserDao) {
        this.getUserDao = getUserDao;
    }

    @Override
    public ArrayList<User> getAllUser() {
        //直接返回所有的用户
        return getUserDao.getAllUser();
    }
}
