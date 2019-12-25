package dao.goods.impl;

import dao.goods.ISearchGoodDao;
import model.TbShangpin;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/*
 *   #auther:李琪
 *   #date: 2019/12/21
 *   #description
 */
@Repository
public class SearchGoodDao implements ISearchGoodDao {
    HibernateTemplate template;
    @Autowired
    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    @Override
    public ArrayList<TbShangpin> searchGood(String name) {
        List<TbShangpin> list = (List<TbShangpin>) template.find("from TbShangpin tb where  tb.mingcheng like '%"+name+"%'");
        System.out.println(list.size());
        return new ArrayList<>(list);
    }

    @Override
    public ArrayList<TbShangpin> searchGoodUseType(int type1,int type2) {
        List<TbShangpin>list;
        if(0 ==type1&&0 == type2){
           list = (List<TbShangpin>) template.find("from TbShangpin  tb");
        }else if(0 == type2){
            list = (List<TbShangpin>) template.findByNamedParam("from TbShangpin  tb where tb.typeid=:typeid"
            ,"typeid",type1);
        }else {
            list = (List<TbShangpin>) template.findByNamedParam("from TbShangpin tb where tb.typeid=:typeid and tb.type2Id=:typeid2"
            , new String[]{"typeid", "typeid2"}, new Object[]{type1, type2});
        }
        return new ArrayList<TbShangpin>(list);
    }
}
