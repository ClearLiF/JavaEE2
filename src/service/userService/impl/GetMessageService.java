package service.userService.impl;

import dao.userDao.IGetMessage;
import model.TbPinglun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.userService.IGetMessageService;

import java.util.ArrayList;

/*
 *   #auther:李琪
 *   #date: 2019/12/21
 *   #description
 */
@Service
public class GetMessageService implements IGetMessageService {
    IGetMessage getMessage;
    @Autowired
    public void setGetMessage(IGetMessage getMessage) {
        this.getMessage = getMessage;
    }

    @Override
    public ArrayList<TbPinglun> getMessage(int userId) {

        return  getMessage.getMessage(userId);
    }
}
