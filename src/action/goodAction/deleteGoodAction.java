package action.goodAction;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.goods.IDeleteGoodService;

/*
 *   #auther:李琪
 *   #date: 2019/12/21
 *   #description
 */
@Controller
public class deleteGoodAction extends ActionSupport {
    int id;

    IDeleteGoodService goodService;
    @Autowired
    public void setGoodService(IDeleteGoodService goodService) {
        this.goodService = goodService;
    }

    @Override
    public String execute() throws Exception {
        goodService.deleteService(id);
        System.out.println("删除成功");
        return SUCCESS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
