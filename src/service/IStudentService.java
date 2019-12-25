package service;

import model.StudentEntity;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IStudentService {
    public void register(StudentEntity student);
}
