package service.type.impl;

import dao.type.IDeleteType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.type.IDeleteTypeService;

/*
 *   #auther:李琪
 *   #date: 2019/12/24
 *   #description
 */
@Service
public class DeleteTypeService implements IDeleteTypeService {
    IDeleteType type;
    @Autowired
    public void setType(IDeleteType type) {
        this.type = type;
    }

    @Override
    public int deleteTypeOne(int id) {

        return type.deleteTypeOne(id);
    }

    @Override
    public int deleteTypeTwo(int id) {
        return type.deleteTypeTwo(id);
    }
}
