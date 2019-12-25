package service.dingdan;

import model.TbDingdan;

import java.util.ArrayList;

public interface IGetAllDingDanService {
    public ArrayList<TbDingdan> getAllDing();
    public int sentDing(int id);
}
