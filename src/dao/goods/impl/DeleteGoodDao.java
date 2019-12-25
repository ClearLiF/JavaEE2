package dao.goods.impl;

import dao.goods.IDeleteGoodDao;
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
public class DeleteGoodDao implements IDeleteGoodDao {
    HibernateTemplate template;
    @Autowired
    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    @Override
    public int deleteGood(int id) {
        List<?> list = template.findByNamedParam("from TbShangpin u where u.id =:id",
                "id",
                id);
        TbShangpin shangpin = (TbShangpin) list.get(0);
        System.out.println("dao层删除评论");
        System.out.println(shangpin.getTbPingluns().size());

        template.delete(shangpin);

        return 0;
    }
}
