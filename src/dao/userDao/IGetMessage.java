package dao.userDao;

import model.TbPinglun;

import java.util.ArrayList;

public interface IGetMessage {
    public ArrayList<TbPinglun>  getMessage(int userId);
}
