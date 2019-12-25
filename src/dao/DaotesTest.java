package dao;

import dao.userDao.impl.GetUserDao;
import model.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.IStudentService;

import java.util.ArrayList;
import java.util.Iterator;

/*
 *   #auther:李琪
 *   #date: 2019/12/20
 *   #description
 */
public class DaotesTest {
    @Test
    public void test(){
        ApplicationContext context;
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        GetUserDao userDao= (GetUserDao) context.getBean(GetUserDao.class);
        ArrayList<User> list=  userDao.getAllUser();

       Iterator<User> iterator =  list.listIterator();
       while (iterator.hasNext()){
           System.out.println(iterator.next());

       }
    }
}
