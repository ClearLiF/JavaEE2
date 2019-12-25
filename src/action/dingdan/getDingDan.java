package action.dingdan;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.dingdan.IGetAllDingDanService;

import javax.servlet.http.HttpServletRequest;

/*
 *   #auther:李琪
 *   #date: 2019/12/25
 *   #description
 */
@Controller
public class getDingDan extends ActionSupport implements ServletRequestAware {
    HttpServletRequest httpServletRequest;
    IGetAllDingDanService service;
    @Autowired
    public void setService(IGetAllDingDanService service) {
        this.service = service;
    }
    /*返回所有订单*/
    public String getAll(){
        ActionContext contextMap = ActionContext.getContext();
        contextMap.getSession().put("dingdan",service.getAllDing());
        return SUCCESS;
    }

    /*发货*/
    public String sendDingdan(){

        service.sentDing(Integer.parseInt( httpServletRequest.getParameter("id")));

        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest=httpServletRequest;
    }
}
