package service.userService;

import model.TbPinglun;

import java.util.ArrayList;

public interface IGetMessageService {
    public ArrayList<TbPinglun> getMessage(int userId);
}
