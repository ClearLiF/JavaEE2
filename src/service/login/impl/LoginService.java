package service.login.impl;

import dao.IStudentDao;
import dao.login.ILoginDao;
import model.StudentEntity;
import service.login.ILoginService;

/*
 *   #auther:李琪
 *   #date: 2019/12/19
 *   #description
 */
public class LoginService implements ILoginService {

    ILoginDao loginDao;

    public void setLoginDao(ILoginDao loginDao) {
        this.loginDao = loginDao;
    }

    @Override
    public boolean StudentLoginService(StudentEntity studentEntity) {
        System.out.println("service层登录");
        return  loginDao.loginDao(studentEntity);
    }
}
