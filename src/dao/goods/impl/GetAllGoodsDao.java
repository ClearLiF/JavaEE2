package dao.goods.impl;

import dao.goods.IGetAllGoods;
import model.TbShangpin;
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
public class GetAllGoodsDao implements IGetAllGoods {
    HibernateTemplate template;
    @Autowired
    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    @Override
    public ArrayList<TbShangpin> getGoods() {

        List<TbShangpin> list = (List<TbShangpin>) template.find("from TbShangpin shangpin");

        return new ArrayList<TbShangpin>(list);
    }
}
