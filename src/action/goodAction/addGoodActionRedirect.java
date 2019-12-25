package action.goodAction;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.type.IGetAllTypeService;

import javax.servlet.http.HttpServletRequest;

/*
 *   #auther:李琪
 *   #date: 2019/12/21
 *   #description
 */
@Controller
public class addGoodActionRedirect extends ActionSupport implements ServletRequestAware {
    IGetAllTypeService typeService;
    HttpServletRequest httpServletRequest;
    @Autowired
    public void setTypeService(IGetAllTypeService typeService) {
        this.typeService = typeService;
    }

    @Override
    public String execute() throws Exception {
        httpServletRequest.getSession().setAttribute("alltype",typeService.getALl());
        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }
}
