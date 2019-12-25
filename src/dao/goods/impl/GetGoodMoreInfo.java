package dao.goods.impl;

import dao.goods.IGetGoodMoreInfo;
import model.TbShangpin;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 *   #auther:李琪
 *   #date: 2019/12/21
 *   #description
 */
@Repository
public class GetGoodMoreInfo implements IGetGoodMoreInfo {
    HibernateTemplate template;
    @Autowired
    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    @Override
    public TbShangpin getGood(int id) {
        System.out.println("商品的"+id);
         List<?> list =  template.findByNamedParam("from  TbShangpin  tb where  tb.id =:id",
                 "id"
                 ,id);
        TbShangpin tbShangpin = (TbShangpin) list.get(0);
        System.out.println("此商品评论的数目为"+ tbShangpin.getTbPingluns().size());

        return (TbShangpin) list.get(0);
    }
}
