package action.goodAction;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.goods.IGetAllGoodsService;

import javax.servlet.http.HttpServletRequest;

/*
 *   #auther:李琪
 *   #date: 2019/12/21
 *   #description
 */
@Controller
public class getAllGoodAction extends ActionSupport implements ServletRequestAware {
    IGetAllGoodsService goodsService;
    HttpServletRequest httpServletRequest;
    @Autowired
    public void setGoodsService(IGetAllGoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest=httpServletRequest;
    }

    @Override
    public String execute() throws Exception {
        httpServletRequest.getSession().setAttribute("GoodList",goodsService.getAllGoods());
        return SUCCESS;
    }
}
