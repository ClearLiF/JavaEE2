package dao.userDao.impl;

import dao.userDao.IDeleteUserDao;

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
public class DeleteUserDao implements IDeleteUserDao {
    private HibernateTemplate template;
    @Autowired
    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    @Override
    public int deleteUserDao(int id) {
        User user = new User();
        user.setId(id);
        /* template.findByNamedParam("from  StudentEntity studentEntity where studentEntity.username=:username and " +
                "studentEntity.password=:password",paraName,values)*/
        System.out.println("传过来的id为"+id);

        List<?> list = template.findByNamedParam("from User u where u.id =:name",
                "name",
                id);
        User user1 = (User) list.get(0);
        System.out.println(user1);
        template.delete(user1);
        /*
        *
        * try {
                 Login login=(Login)this.getHibernateTemplate().load(Login.class,lid);
                    getHibernateTemplate().delete(login);
                    log.debug("delete successful");
                } catch (RuntimeException re) {
                    log.error("delete failed", re);
                    throw re;
                }

        * */
        return 0;
    }
}
