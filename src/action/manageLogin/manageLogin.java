package action.manageLogin;

import com.opensymphony.xwork2.ActionSupport;

/*
 *   #auther:李琪
 *   #date: 2019/12/20
 *   #description
 */
public class manageLogin extends ActionSupport {
    @Override
    public String execute() throws Exception {
        System.out.println("管理员登录");
        return SUCCESS;
    }
}
