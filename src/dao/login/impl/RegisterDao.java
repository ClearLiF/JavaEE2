package dao.login.impl;

import dao.login.IRegister;
import model.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

/*
 *   #auther:李琪
 *   #date: 2019/12/19
 *   #description
 */
@Repository
public class RegisterDao implements IRegister {

    private HibernateTemplate template ;

    @Autowired
    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    @Override
    public boolean registerDao(StudentEntity studentEntity) {

        System.out.println("注册dao");
        template.save(studentEntity);
        return true;
    }
}
