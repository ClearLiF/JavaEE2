package action.actionUser;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.userService.IDeleteUserService;

/*
 *   #auther:李琪
 *   #date: 2019/12/20
 *   #description
 */
@Controller
public class deleteUser extends ActionSupport {
    String id;


    IDeleteUserService userService;
    @Autowired
    public void setUserService(IDeleteUserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute() throws Exception {
        //删除操作
        userService.deleteUser(Integer.parseInt(id));
        return SUCCESS;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
