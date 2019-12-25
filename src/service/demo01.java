package service;

import model.StudentEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 *   #auther:李琪
 *   #date: 2019/12/18
 *   #description
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class demo01 {
    //@Autowired
    private IStudentService studentService;

    public void setStudentService(IStudentService studentService) {
        this.studentService = studentService;
    }


    public void test1(){
        ApplicationContext context;
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IStudentService studentService = (IStudentService) context.getBean("studentService");
        StudentEntity student = new StudentEntity(2,"123","10dw","5564");
       studentService.register(student);
    }

    public static void main(String[] args) {
        new demo01().test1();
    }
}
