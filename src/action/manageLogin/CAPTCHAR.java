package action.manageLogin;

import cn.dsna.util.images.ValidateCode;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.result.StrutsResultSupport;
import org.springframework.context.annotation.Scope;

import java.util.Map;

/*
 *   #auther:李琪
 *   #date: 2019/11/6
 *   #description
 */
@Scope("prototype")
public class CAPTCHAR extends StrutsResultSupport {
    private  int   width=100;
    private  int    height=30;
    @Override
    protected void doExecute(String s, ActionInvocation actionInvocation) throws Exception {
        ValidateCode code = new ValidateCode(width,height,4,6);
        javax.servlet.http.HttpServletResponse  response= ServletActionContext.getResponse();
        //把图片返回客户端
        ActionContext act=ActionContext.getContext();
        Map<String,Object> sessionMap=(Map<String,Object>)act.getSession();
        sessionMap.put("captchar",code.getCode());
        code.write(response.getOutputStream());

    }



}
