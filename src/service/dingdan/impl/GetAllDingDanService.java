package service.dingdan.impl;

import dao.dingdan.IGetAllDingDan;
import model.TbDingdan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.dingdan.IGetAllDingDanService;

import java.util.ArrayList;

/*
 *   #auther:李琪
 *   #date: 2019/12/25
 *   #description
 */
@Service
public class GetAllDingDanService implements IGetAllDingDanService {
    IGetAllDingDan dingDan;
    @Autowired
    public void setDingDan(IGetAllDingDan dingDan) {
        this.dingDan = dingDan;
    }

    @Override
    public ArrayList<TbDingdan> getAllDing() {
        return dingDan.getAll();
    }

    @Override
    public int sentDing(int id) {
        return dingDan.send(id);
    }
}
