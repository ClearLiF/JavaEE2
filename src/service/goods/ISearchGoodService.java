package service.goods;

import model.TbShangpin;

import java.util.ArrayList;

public interface ISearchGoodService {
    public ArrayList<TbShangpin> searchGood(String name);
    public ArrayList<TbShangpin> searchGoodByType(int type1,int type2);
}
