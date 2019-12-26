package action.manageLogin;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import model.TbAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import service.login.ILoginService;

import java.util.Map;

/*
 *   #auther:李琪
 *   #date: 2019/12/26
 *   #description
 */
@Controller
/*登录不同的访问必须生成不同的action*/
@Scope("prototype")
public class loginAction extends ActionSupport {
   private String username;
   private String password;
   private String captchar;
   private ILoginService loginService;
    @Autowired
    public void setLoginService(ILoginService loginService) {
        this.loginService = loginService;
    }

    public String login(){
        ActionContext act=ActionContext.getContext();
        Map<String,Object> sessionMap=(Map<String,Object>)act.getSession();
        sessionMap.put("username",username);
        System.out.println(username);
        String cap = (String) sessionMap.get("captchar");
        cap = cap.toUpperCase();
        TbAdmin tbAdmin = new TbAdmin();
        tbAdmin.setName(username);
        tbAdmin.setPwd(password);
        if( cap.equals( captchar.toUpperCase())&&loginService.loginService(tbAdmin)){
            return SUCCESS;
        }else {
            sessionMap.put("err","请仔细检查密码，或者验证码");
            return ERROR;
        }


    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCaptchar() {
        return captchar;
    }

    public void setCaptchar(String captchar) {
        this.captchar = captchar;
    }
}
