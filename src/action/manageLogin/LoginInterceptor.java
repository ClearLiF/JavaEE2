package action.manageLogin;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.springframework.context.annotation.Scope;

import java.util.Map;

/*
 *   #auther:李琪
 *   #date: 2019/11/16
 *   #description
 */
@Scope("prototype")
public class LoginInterceptor extends MethodFilterInterceptor {


    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        ActionContext context = ActionContext.getContext();
        Map<String,Object> stringObjectMap = context.getSession();
        System.out.println("正在过滤");
        if(null!=stringObjectMap.get("username")){
            return actionInvocation.invoke();
        }else {
            return "failure";
        }

    }
}
