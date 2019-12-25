package service.login.impl;

import dao.login.IRegister;
import model.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.login.IRegisterService;

/*
 *   #auther:李琪
 *   #date: 2019/12/19
 *   #description
 */
@Service
public class RegisterService implements IRegisterService {

    IRegister register;
    @Autowired
    public void setRegister(IRegister register) {
        this.register = register;
    }

    @Override
    public boolean StudentRegisterService(StudentEntity studentEntity) {
        System.out.println("注册service");
        register.registerDao(studentEntity);
        return true;
    }
}
