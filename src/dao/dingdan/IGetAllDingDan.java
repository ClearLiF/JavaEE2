package dao.dingdan;

import model.TbDingdan;

import java.util.ArrayList;

public interface IGetAllDingDan {
    public ArrayList<TbDingdan> getAll();
    public int send(int id);
}
