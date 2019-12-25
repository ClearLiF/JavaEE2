package service.type.impl;

import dao.type.IAddTypeDao;
import model.TbType;
import model.TbType2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.type.IAddTypeService;

import java.util.HashSet;
import java.util.Set;

/*
 *   #auther:李琪
 *   #date: 2019/12/24
 *   #description
 */
@Service
public class AddTypeService implements IAddTypeService {
    IAddTypeDao typeDao;
    @Autowired
    public void setTypeDao(IAddTypeDao typeDao) {
        this.typeDao = typeDao;
    }

    /*
    * 初次添加必须添加type2类型
    * */
    @Override
    public int addType1(String type1, String type2) {
        TbType tbType = new TbType();
        tbType.setTypename(type1);
        TbType2 tbType2 = new TbType2();
        //如果是空值 的话直接加个1

        tbType2.setTypename(type1.concat("1465165"));
        tbType2.setTbTypeByTypeid(tbType);
        tbType.getTbType2sById().add(tbType2);
        /*调用dao方法存数据*/
        return  typeDao.addType1(tbType);
    }

    @Override
    public int addType2(int type1, String type2) {
        TbType2 tbType2 = new TbType2();
        tbType2.setTypename(type2);
        /*
        hibernate需要设置对应的值，维持一对多关系
        * */
        TbType tbType = new TbType();
        tbType.setId(type1);
        tbType2.setTbTypeByTypeid(tbType);
        typeDao.addType2(tbType2);
        return 0;
    }
}
