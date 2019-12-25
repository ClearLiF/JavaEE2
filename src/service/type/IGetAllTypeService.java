package service.type;

import model.TbType;
import model.TbType2;

import java.util.ArrayList;

public interface IGetAllTypeService {
    public ArrayList<TbType> getALl();
    public  ArrayList<TbType2> getTwoType(int  id);
}
