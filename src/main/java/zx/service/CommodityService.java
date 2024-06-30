package zx.service;

import zx.bean.Commodity;
import zx.bean.HomeData;
import zx.dao.CommodityDao;

import java.util.List;


public class CommodityService {

   public static void prepareForHomeData(HomeData homeData){

      if(homeData.getKeyword() == null){
         CommodityDao.selectForHomeBySort(homeData);
      }else {
         // 关键字查询
         String keyword = homeData.getKeyword();
         CommodityDao.selectForHomeByKeyword(homeData,keyword);
      }
      // 设置导航栏页码
      homeData.setFirstPageForNavigation();
      homeData.setLastPageForNavigation();


   }

}
