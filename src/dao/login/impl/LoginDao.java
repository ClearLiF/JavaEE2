package dao.login.impl;

import dao.login.ILoginDao;
import model.StudentEntity;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

/*
 *   #auther:李琪
 *   #date: 2019/12/19
 *   #description
 */
public class LoginDao implements ILoginDao {
    private HibernateTemplate template ;

    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    @Override
    public boolean loginDao(StudentEntity studentEntity) {
        System.out.println("登录dao层");
        System.out.println(studentEntity);
        String[] paraName = new String[]{"username","password"};
        String[] values = new String[]{studentEntity.getUsername(),studentEntity.getPassword()};

        List<?> list=  template.findByNamedParam("from  StudentEntity studentEntity where studentEntity.username=:username and " +
                "studentEntity.password=:password",paraName,values);

        return list.size() != 0;


    }
}
