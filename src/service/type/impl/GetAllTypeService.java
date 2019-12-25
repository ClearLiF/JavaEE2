package service.type.impl;

import dao.type.IGetAllTypeDao;
import model.TbType;
import model.TbType2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.type.IGetAllTypeService;

import java.util.ArrayList;
import java.util.Iterator;

/*
 *   #auther:李琪
 *   #date: 2019/12/21
 *   #description
 */
@Service
public class GetAllTypeService implements IGetAllTypeService {
    IGetAllTypeDao typeDao;
    @Autowired
    public void setTypeDao(IGetAllTypeDao typeDao) {
        this.typeDao = typeDao;
    }

    @Override
    public ArrayList<TbType> getALl() {
        return typeDao.getType();
    }

    @Override
    public ArrayList<TbType2> getTwoType(int id) {
        ArrayList<TbType> tbTypes = typeDao.getType();
        TbType tbType =null;
        Iterator<TbType> iterator = tbTypes.listIterator();
        while (iterator.hasNext()){
            tbType=iterator.next();
            if ( tbType.getId()==id){
                    return new  ArrayList<TbType2>(tbType.getTbType2sById());
            }

        }
        return null;
    }
}
