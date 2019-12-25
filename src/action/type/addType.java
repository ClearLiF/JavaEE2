package action.type;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.type.IAddTypeService;
import service.type.IGetAllTypeService;

import javax.servlet.http.HttpServletRequest;

/*
 *   #auther:李琪
 *   #date: 2019/12/24
 *   #description
 */
@Controller
public class addType extends ActionSupport  implements ServletRequestAware {
    IGetAllTypeService typeService;
    HttpServletRequest httpServletRequest;
    IAddTypeService addTypeService;
    int id;
    @Autowired
    public void setAddTypeService(IAddTypeService addTypeService) {
        this.addTypeService = addTypeService;
    }
    @Autowired
    public void setTypeService(IGetAllTypeService typeService) {
        this.typeService = typeService;
    }

    public String addType1(){
        String name = httpServletRequest.getParameter("typename");
        //第二类先传空值吧  ，先自动生成一个二类
        //返回值为插入的一类id
        int id =addTypeService.addType1(name,null);

        httpServletRequest.getSession().setAttribute("type",typeService.getTwoType(id));
        //System.out.println(typeService.getTwoType(id).size());
        httpServletRequest.getSession().setAttribute("typeid",id);
        return SUCCESS;
    }
    public String addType2(){
        //获取一类id
        int id =Integer.parseInt(httpServletRequest.getParameter("typeid"));
        //获取二类姓名u
        String name = httpServletRequest.getParameter("typename");
        addTypeService.addType2(id,name);
        //返回当前页面并刷新
        this.setId(id);
        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {

        this.httpServletRequest=httpServletRequest;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
