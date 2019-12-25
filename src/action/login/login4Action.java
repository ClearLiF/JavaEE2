package action.login;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import model.StudentEntity;
import org.apache.commons.lang3.StringUtils;
import service.login.ILoginService;

/*
 *   #auther:李琪
 *   #date: 2019/11/9
 *   #description
 */
public class login4Action extends ActionSupport implements ModelDriven<StudentEntity> {
    /*这个属性一定要实例化*/
    private StudentEntity studentEntity = new StudentEntity();
/*第四种方式通过模型驱动,在action里实现一个模型驱动的接口*/
    ILoginService studentLoginService;

    public void setStudentLoginService(ILoginService studentLoginService) {
        System.out.println("调用login的action");
        this.studentLoginService = studentLoginService;
    }

    public  String login(){
        if(  studentLoginService.StudentLoginService(studentEntity)){

            System.out.println("登录成功");
            return   SUCCESS;
        }
       else {
           return NONE;
        }

    }
    @Override
    public void validate() {
        if (StringUtils.isEmpty( studentEntity.getUsername())){
            addFieldError("username","名字不能为空");
        }


    }
    @Override
    public  StudentEntity getModel() {
        return  studentEntity;
    }
}
