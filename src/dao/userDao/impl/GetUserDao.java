package dao.userDao.impl;

import dao.userDao.IGetUserDao;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/*
 *   #auther:李琪
 *   #date: 2019/12/20
 *   #description
 */
@Repository
public class GetUserDao implements IGetUserDao {
    private HibernateTemplate template ;

    @Autowired
    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }
    @Override
    public ArrayList<User> getAllUser() {

        List<User> list = (List<User>) template.find("from  User user ");


        return (ArrayList<User>) list;
    }
}
