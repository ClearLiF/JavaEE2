package dao.login.impl;

import dao.login.ILoginDao;
import model.StudentEntity;
import model.TbAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 *   #auther:李琪
 *   #date: 2019/12/19
 *   #description
 */
@Repository
public class LoginDao implements ILoginDao {
    private HibernateTemplate template ;
    @Autowired
    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    @Override
    public boolean loginDao(TbAdmin admin) {
        System.out.println("登录dao层");
        String[] paraName = new String[]{"username","password"};
        String[] values = new String[]{admin.getName(),admin.getPwd()};

        template.save(admin);
        List<?> list=  template.findByNamedParam("from TbAdmin tb where tb.name=:username and " +
                "tb.pwd=:password",paraName,values);

        return list.size() != 0;


    }
}
