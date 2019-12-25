package action.actionUser;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.userService.IDongJieService;

/*
 *   #auther:李琪
 *   #date: 2019/12/21
 *   #description
 */
@Controller
public class dongJieUser extends ActionSupport  {
    int type;
    int id;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    IDongJieService dongJieService;
    @Autowired
    public void setDongJieService(IDongJieService dongJieService) {
        this.dongJieService = dongJieService;
    }

    @Override
    public String execute() throws Exception {
        System.out.println("冻结id和类型为"+id+type);
        dongJieService.dongJie(id,type) ;
        return SUCCESS;
    }
}
