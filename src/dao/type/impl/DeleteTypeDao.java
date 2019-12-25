package dao.type.impl;

import dao.type.IDeleteType;
import model.TbType;
import model.TbType2;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 *   #auther:李琪
 *   #date: 2019/12/24
 *   #description
 */
@Repository
public class DeleteTypeDao  implements IDeleteType  {
    HibernateTemplate template;
    @Autowired
    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    @Override
    public int deleteTypeOne(int id) {
        System.out.println("传过来的id为"+id);

        List<?> list = template.findByNamedParam("from TbType u where u.id =:name",
                "name",
                id);
        TbType tbType = (TbType) list.get(0);
        System.out.println(tbType);
        template.delete(tbType);



        return 0;
    }

    @Override
    public int deleteTypeTwo(int id) {
      Session session =  template.getSessionFactory().openSession();
        session.getTransaction().begin();
        System.out.println("传过来的id为"+id);

        List<?> list = template.findByNamedParam("from TbType2 u where u.id =:name",
                "name",
                id);
        TbType2 tbType = (TbType2) list.get(0);
        System.out.println(tbType);
        tbType.setTbTypeByTypeid(null);

        session.update(tbType);
        session.getTransaction().commit();
        session.delete(tbType);
        session.getTransaction().commit();
        System.out.println("执行");
         session.close();
        return 0;
    }
}
