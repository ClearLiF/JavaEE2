package action.login;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import model.StudentEntity;
import service.login.IRegisterService;

/*
 *   #auther:李琪
 *   #date: 2019/12/19
 *   #description
 */
public class registerAction extends ActionSupport implements ModelDriven<StudentEntity> {
    StudentEntity studentEntity = new StudentEntity();
    private IRegisterService registerService;

    public void setRegisterService(IRegisterService registerService) {
        this.registerService = registerService;
    }
    @Override
    public String execute() throws Exception {
        System.out.println(studentEntity);
        registerService.StudentRegisterService(studentEntity);
        return SUCCESS;
    }

    @Override
    public StudentEntity getModel() {
        return studentEntity;
    }
}
