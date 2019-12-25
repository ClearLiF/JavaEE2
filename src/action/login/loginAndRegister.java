package action.login;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import model.StudentEntity;
import org.apache.struts2.ServletActionContext;
import service.login.IRegisterService;

import javax.servlet.http.HttpServletRequest;

/*
 *   #auther:李琪
 *   #date: 2019/12/19
 *   #description
 */
public class loginAndRegister extends ActionSupport implements ModelDriven<StudentEntity> {
    private String msg;
    private StudentEntity studentEntity = new StudentEntity();


    @Override
    public String execute() throws Exception {
        return super.execute();
    }

    // 处理save submit按钮的动作
    public String login2() throws Exception
    {
        System.out.println(studentEntity);
        System.out.println("login中的操作");

        return "login2";
    }

    // 处理print submit按钮的动作
    public String register2() throws Exception
    {


        System.out.println("register中的操作");

        return "register2";
    }
    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    @Override
    public StudentEntity getModel() {
        return  studentEntity;
    }
}
