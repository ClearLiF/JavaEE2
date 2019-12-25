package action.register;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import model.StudentEntity;
import service.IStudentService;

/*
 *   #auther:李琪
 *   #date: 2019/12/19
 *   #description
 */
public class UserAction extends ActionSupport implements ModelDriven<StudentEntity> {
    private StudentEntity studentEntity = new StudentEntity();

    private IStudentService studentService;

    public void setStudentService(IStudentService studentService) {
        System.out.println("调用service");
        this.studentService = studentService;
    }

    public String register(){
        System.out.println("dwqdqwdw");
        System.out.println(studentEntity);
        studentService.register(studentEntity);
        return SUCCESS;
    }

    @Override
    public StudentEntity getModel() {
        return studentEntity;
    }
}
