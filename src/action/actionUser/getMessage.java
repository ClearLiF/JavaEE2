package action.actionUser;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.userService.IGetMessageService;

import javax.servlet.http.HttpServletRequest;

/*
 *   #auther:李琪
 *   #date: 2019/12/21
 *   #description
 */
@Controller
public class getMessage extends ActionSupport implements ServletRequestAware {
    HttpServletRequest httpServletRequest;
    IGetMessageService service;
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HttpServletRequest getHttpServletRequest() {
        return httpServletRequest;
    }

    public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    @Autowired
    public void setService(IGetMessageService service) {
        this.service = service;
    }

    @Override
    public String execute() throws Exception {


        httpServletRequest.getSession().setAttribute("comments", service.getMessage(id));
        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest=httpServletRequest;
    }
}
