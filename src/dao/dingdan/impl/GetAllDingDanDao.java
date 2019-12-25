package dao.dingdan.impl;

import dao.dingdan.IGetAllDingDan;
import model.TbDingdan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/*
 *   #auther:李琪
 *   #date: 2019/12/25
 *   #description
 */
@Repository
public class GetAllDingDanDao implements IGetAllDingDan {
    HibernateTemplate template;
    @Autowired
    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    @Override
    public ArrayList<TbDingdan> getAll() {
        List<TbDingdan> list = (List<TbDingdan>) template.find("from TbDingdan  tb");

        return new ArrayList<>(list);
    }

    @Override
    public int send(int id) {
       List<TbDingdan> list = (List<TbDingdan>) template.findByNamedParam("from  TbDingdan tb where tb.id=:id","id",id);
       TbDingdan dingdan = list.get(0);
       dingdan.setZt("卖家已发货");
       template.update(dingdan);

        return 0;
    }
}
