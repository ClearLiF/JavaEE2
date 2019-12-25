package action.goodAction;

import com.opensymphony.xwork2.ActionSupport;
import model.TbPinglun;
import model.TbShangpin;
import model.User;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.goods.IGetAllGoodsService;
import service.goods.IGetGoodsMore;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/*
 *   #auther:李琪
 *   #date: 2019/12/21
 *   #description
 */
@Controller
public class getGoodMore extends ActionSupport  implements ServletRequestAware {

    int id;
    IGetGoodsMore getGoodsMore;
    HttpServletRequest httpServletRequest;
    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest=httpServletRequest;
    }


   @Autowired
    public void setGetGoodsMore(IGetGoodsMore getGoodsMore) {
        this.getGoodsMore = getGoodsMore;
    }


    @Override
    public String execute() throws Exception {
        TbShangpin u = getGoodsMore.getGoodMore(id);
        httpServletRequest.getSession().setAttribute("Goodmore",u);
        httpServletRequest.getSession().setAttribute("GoodComment",new ArrayList<TbPinglun>(u.getTbPingluns()));

        return SUCCESS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
