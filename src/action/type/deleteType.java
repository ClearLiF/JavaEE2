package action.type;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.type.IDeleteTypeService;

import javax.servlet.http.HttpServletRequest;

/*
 *   #auther:李琪
 *   #date: 2019/12/24
 *   #description
 */
@Controller
public class deleteType extends ActionSupport implements ServletRequestAware {
    HttpServletRequest httpServletRequest;
    IDeleteTypeService service;
    @Autowired
    public void setService(IDeleteTypeService service) {

        this.service = service;
    }
    public String deleteTypeOne(){
        int id = Integer.parseInt(httpServletRequest.getParameter("id"));
        service.deleteTypeOne(id);
        System.out.println("删除指定id类型");
        return SUCCESS;
    }
    public String deleteTypeTwo(){
        /*子类id获取,为删除子类*/
        int id = Integer.parseInt(httpServletRequest.getParameter("id"));
        service.deleteTypeTwo(id);
        /*父类id获取,为返回页面做准备*/
        int type1 = Integer.parseInt(httpServletRequest.getParameter("type1"));

        httpServletRequest.setAttribute("id",type1);
        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest=httpServletRequest;
    }
}
