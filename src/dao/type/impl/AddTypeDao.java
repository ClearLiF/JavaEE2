package dao.type.impl;

import dao.type.IAddTypeDao;
import model.TbType;
import model.TbType2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/*
 *   #auther:李琪
 *   #date: 2019/12/24
 *   #description
 */
@Repository
public class AddTypeDao implements IAddTypeDao {
    HibernateTemplate template;
    @Autowired
    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    @Override
    public int addType1(TbType tbType) {
        SessionFactory sessionFactory = template.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        //初始化结果类型
        TbType tbType1 = new TbType();
        ArrayList<TbType2> tbType2s =new ArrayList<>(tbType.getTbType2sById());
        session.save(tbType);
        transaction.commit();
        session.save(tbType2s.get(0));
        System.out.println(tbType.getTypename());

        session.close();

        List<TbType> list = (List<TbType>) template.findByNamedParam("from TbType tb where tb.typename=:name"
                    ,"name",
                    tbType.getTypename());
            tbType1=list.get(0);


        return tbType1.getId();
    }

    @Override
    public int addType2(TbType2 tbType) {
        if(tbType!=null){
            template.saveOrUpdate(tbType);
        }
        return 0;
    }
}
