package action.actionUser;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.userService.IGetUserService;

import javax.servlet.http.HttpServletRequest;

/*
 *   #auther:李琪
 *   #date: 2019/12/20
 *   #description
 */
@Controller
public class getAllUser extends ActionSupport implements ServletRequestAware {
    IGetUserService userService;
    HttpServletRequest httpServletRequest;
    @Autowired
    public void setUserService(IGetUserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute() throws Exception {
        //将所有的用户放到session中去
        httpServletRequest.getSession().setAttribute("users",userService.getAllUser());

        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest=httpServletRequest;
    }
}
