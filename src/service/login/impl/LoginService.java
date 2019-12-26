package service.login.impl;

import dao.IStudentDao;
import dao.login.ILoginDao;
import model.StudentEntity;
import model.TbAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.login.ILoginService;

/*
 *   #auther:李琪
 *   #date: 2019/12/19
 *   #description
 */
@Service
public class LoginService implements ILoginService {

    ILoginDao loginDao;
    @Autowired
    public void setLoginDao(ILoginDao loginDao) {
        this.loginDao = loginDao;
    }

    @Override
    public boolean loginService(TbAdmin admin) {
        System.out.println("service层登录");
        return  loginDao.loginDao(admin);
    }
}
