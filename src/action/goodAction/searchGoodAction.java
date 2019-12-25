package action.goodAction;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.goods.ISearchGoodService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/*
 *   #auther:李琪
 *   #date: 2019/12/21
 *   #description
 */
@Controller
public class searchGoodAction extends ActionSupport   implements ServletRequestAware {
    ISearchGoodService searchGoodService;
    HttpServletRequest httpServletRequest;
    @Autowired
    public void setSearchGoodService(ISearchGoodService searchGoodService) {
        this.searchGoodService = searchGoodService;
    }
    public String searchUseString(){
        String search = httpServletRequest.getParameter("search_title");
        System.out.println("收到的查询为"+search);
        httpServletRequest.getSession().setAttribute("GoodList",searchGoodService.searchGood(search));
        return SUCCESS;
    }
    public String searchGoodByType(){
        int type1 = httpServletRequest.getParameter("typeId")==null?0:
                Integer.parseInt(httpServletRequest.getParameter("typeId"));
        int type2 = httpServletRequest.getParameter("typeId")==null?0:
                Integer.parseInt(httpServletRequest.getParameter("type2Id"));

        httpServletRequest.getSession().setAttribute("GoodList",
               searchGoodService.searchGoodByType(type1,type2));
        return SUCCESS;

    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }
}
