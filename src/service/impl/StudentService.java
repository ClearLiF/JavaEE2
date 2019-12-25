package service.impl;

import dao.IStudentDao;
import model.StudentEntity;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import service.IStudentService;

/*
 *   #auther:李琪
 *   #date: 2019/12/18
 *   #description
 */
@Transactional
public class StudentService implements IStudentService {
    private IStudentDao studentDao;
    @Transactional
    @Override
    public void register(StudentEntity student) {
        studentDao.add(student);
    }

    public void setStudentDao(IStudentDao studentDao) {
        this.studentDao = studentDao;
    }
}
