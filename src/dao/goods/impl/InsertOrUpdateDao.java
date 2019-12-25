package dao.goods.impl;

import dao.goods.IInsertOrUpdateDao;
import model.TbShangpin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

/*
 *   #auther:李琪
 *   #date: 2019/12/21
 *   #description
 */
@Repository
public class InsertOrUpdateDao implements IInsertOrUpdateDao {
    HibernateTemplate template;
    @Autowired
    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    @Override
    public int InsertOrUpdate(TbShangpin shangpin) {

        template.saveOrUpdate(shangpin);
        return 0;
    }
}
