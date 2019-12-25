package dao.userDao.impl;

import dao.userDao.IGetMessage;
import model.TbPinglun;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 *   #auther:李琪
 *   #date: 2019/12/21
 *   #description
 */
@Repository
public class GetMessAgeDao implements IGetMessage {

    HibernateTemplate template;
    @Autowired
    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    @Override
    public ArrayList<TbPinglun> getMessage(int userId) {

        System.out.println(userId);
        List<?> list =  template.findByNamedParam("from User u where u.id=:userid","userid",userId);
        System.out.println(list.size());
        //到时候记得删除
        User user = (User) list.get(0);
        Set<TbPinglun> sets = user.getPingluns();




        System.out.println(user);
        ArrayList<TbPinglun> tbPingluns = new ArrayList<TbPinglun>(sets);
        System.out.println("数目为"+tbPingluns.size());
        return tbPingluns;
    }
}
