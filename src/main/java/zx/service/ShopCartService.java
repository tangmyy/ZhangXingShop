package zx.service;

import com.sun.media.sound.RIFFInvalidFormatException;
import zx.bean.Commodity;
import zx.bean.HomeData;
import zx.bean.MyShopCartDate;
import zx.bean.MyShopCartItemData;
import zx.dao.CommodityDao;

public class ShopCartService {
   public static void dispathServiceType(String serviceType, String commodityId, String isChecked, MyShopCartDate myShopCartDate) {
      switch (serviceType){
         case "addToCart":
            addToCart(commodityId, myShopCartDate);
            break;
         case "updateByCheckedBox":
            updateByCheckedBox(commodityId, isChecked, myShopCartDate);
            break;
         case "updateAllCheckedBox":
            boolean allChecked = Boolean.parseBoolean(isChecked); // �� isChecked ����Ϊȫѡ״̬
            updateAllCheckedBox(myShopCartDate, allChecked);
         break;
         case "remove":
            remove(commodityId, myShopCartDate);
            break;
         default:             // ���û��ƥ���case��ִ�У�
            break;
      }
   }

   public static void dispathServiceType(String serviceType, String commodityId, MyShopCartDate myShopCartDate, int changeNum) {
      if(serviceType.equals("updateByNum")){
         updateByNum(commodityId, myShopCartDate, changeNum);
      }
   }

   private static void updateByCheckedBox(String commodityId, String isChecked, MyShopCartDate myShopCartDate) {
      boolean checked = Boolean.parseBoolean(isChecked);
      myShopCartDate.updateByCheckedBox(commodityId, checked);
   }

   public static void updateAllCheckedBox(MyShopCartDate myShopCartDate, boolean isChecked) {
      myShopCartDate.updateAllCheckedBox(isChecked);
   }



   private static void remove(String commodityId, MyShopCartDate myShopCartDate) {
      myShopCartDate.remove(commodityId);
   }
   private static void updateByNum(String commodityId, MyShopCartDate myShopCartDate, int changeNum) {
         myShopCartDate.updateByNum(commodityId, changeNum);
   }


   public static void addToCart(String commodityId, MyShopCartDate myShopCartDate){
      if(myShopCartDate.getCartList().containsKey(commodityId)){     // ��ǰ���ﳵ�д���Ʒ ����������ѡ��
         // �Ȱѵ�ǰ��棬��Ҫʹ������
         MyShopCartItemData myShopCartItemData = myShopCartDate.getCartList().get(commodityId);
         myShopCartDate.remove(commodityId);       // remove���Ѿ�ʵ�ָ����ܼ�
         myShopCartDate.add(myShopCartItemData.getCommodity(),myShopCartItemData.getNum()+1);
      }else{
         // ��׼�� Commodity ����ͨ��commodityDao���ѯ�������õ�����
         Commodity commodity = CommodityDao.selectCommodityById(Integer.parseInt(commodityId));
         myShopCartDate.add(commodity, 1);
      }
   }


}
