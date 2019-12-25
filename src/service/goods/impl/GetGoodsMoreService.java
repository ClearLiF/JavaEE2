package service.goods.impl;

import dao.goods.IGetGoodMoreInfo;
import model.TbShangpin;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.goods.IGetGoodsMore;

/*
 *   #auther:李琪
 *   #date: 2019/12/21
 *   #description
 */
@Service
public class GetGoodsMoreService implements IGetGoodsMore {
    IGetGoodMoreInfo getGoodMoreInfo;
    @Autowired
    public void setGetGoodMoreInfo(IGetGoodMoreInfo getGoodMoreInfo) {
        this.getGoodMoreInfo = getGoodMoreInfo;
    }

    @Override
    public TbShangpin getGoodMore(int id) {

        return getGoodMoreInfo.getGood(id);
    }
}
