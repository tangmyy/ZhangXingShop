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
         // �ؼ��ֲ�ѯ
         String keyword = homeData.getKeyword();
         CommodityDao.selectForHomeByKeyword(homeData,keyword);
      }
      // ���õ�����ҳ��
      homeData.setFirstPageForNavigation();
      homeData.setLastPageForNavigation();


   }

}
