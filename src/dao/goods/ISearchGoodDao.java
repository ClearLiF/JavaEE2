package dao.goods;

import model.TbShangpin;
import model.User;

import java.util.ArrayList;

public interface ISearchGoodDao {
    public ArrayList<TbShangpin> searchGood(String name);
    public ArrayList<TbShangpin> searchGoodUseType(int type1,int type2);
}
