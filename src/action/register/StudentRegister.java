package action.register;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import model.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.login.IRegisterService;

/*
 *   #auther:李琪
 *   #date: 2019/12/19
 *   #description
 */
@Controller
public class StudentRegister extends ActionSupport implements ModelDriven<StudentEntity> {
    StudentEntity studentEntity = new StudentEntity();


    IRegisterService registerService;
    @Autowired
    public void setRegisterService(IRegisterService registerService) {
        this.registerService = registerService;
    }

    @Override
    public String execute() throws Exception {
        registerService.StudentRegisterService(studentEntity);
        return SUCCESS;
    }

    @Override
    public StudentEntity getModel() {
        return studentEntity ;
    }
}
