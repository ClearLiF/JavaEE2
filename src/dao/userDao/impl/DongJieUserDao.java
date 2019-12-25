package dao.userDao.impl;

import dao.userDao.IDeleteUserDao;
import dao.userDao.IDongJieDao;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 *   #auther:李琪
 *   #date: 2019/12/20
 *   #description
 */
@Repository
public class DongJieUserDao implements IDongJieDao {
    private HibernateTemplate template;
    @Autowired
    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }


    @Override
    public int dongJie(int id,int type) {
        User user = this.template.get(User.class,id);
        user.setDongjie(type);
        template.update(user);
        return 0;
    }
}
