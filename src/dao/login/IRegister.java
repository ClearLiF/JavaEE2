package dao.login;

import model.StudentEntity;
import org.springframework.stereotype.Repository;


public interface IRegister {

    public  boolean registerDao(StudentEntity studentEntity);
}
