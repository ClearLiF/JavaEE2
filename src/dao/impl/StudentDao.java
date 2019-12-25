package dao.impl;

import dao.IStudentDao;
import model.StudentEntity;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/*
 *   #auther:李琪
 *   #date: 2019/12/18
 *   #description
 */
public class StudentDao implements IStudentDao {
    private  HibernateTemplate template ;
    @Override
    public void add(StudentEntity student) {

        template.save(student);

    }

    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }
}
