package action.type;

import com.opensymphony.xwork2.ActionSupport;
import model.TbType;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.type.IGetAllTypeService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Iterator;

/*
 *   #auther:李琪
 *   #date: 2019/12/22
 *   #description
 */
@Controller
public class defineTypeFirst extends ActionSupport implements ServletRequestAware {
    IGetAllTypeService typeService;
    HttpServletRequest httpServletRequest;
    //添加时要使用的id
    int id;
    @Autowired
    public void setTypeService(IGetAllTypeService typeService) {
        this.typeService = typeService;
    }

    @Override
    public String execute() throws Exception {
        httpServletRequest.getSession().setAttribute("alltype",typeService.getALl());
        return SUCCESS;
    }
    public String getTypeTwo(){


        int id = this.id;


        System.out.println("前台id"+id);
        httpServletRequest.getSession().setAttribute("type",typeService.getTwoType(id));
        System.out.println(typeService.getTwoType(id).size());
        httpServletRequest.getSession().setAttribute("typeid",id);

        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
