package dao.type.impl;

import dao.type.IGetAllTypeDao;
import model.TbType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/*
 *   #auther:李琪
 *   #date: 2019/12/21
 *   #description
 */
@Repository
public class GetAllTypeDao implements IGetAllTypeDao {
    HibernateTemplate template;
    @Autowired
    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    @Override
    public ArrayList<TbType> getType() {
        List<TbType> list = (List<TbType>) template.find("from  TbType tb");
        TbType tbType = list.get(0);
        System.out.println(tbType.getTbType2sById().size());
        return new  ArrayList<TbType>(list);
    }
}
