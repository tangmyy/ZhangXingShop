package zx.bean;

import java.math.BigDecimal;

public class MyShopCartItemData {
   private boolean checked;   // ��ʾ��ǰ��Ʒ�ڹ��ﳵ�е�ѡ��״̬ �����Ƿ�Ҫ����ͳ��
   private Commodity commodity;
   private int num;  // ��ǰ���ﳵ�ڸ���Ʒ������
   private BigDecimal subtotal;   // ��ǰ���ﳵ����Ʒ���С��

   public MyShopCartItemData(boolean checked, Commodity commodity, int num) {
      this.checked = checked;
      this.commodity = commodity;
      this.num = num;
      setSubtotal();
   }

   public boolean getChecked() {
      return checked;
   }

   public void setChecked(boolean checked) {
      this.checked = checked;
   }

   public Commodity getCommodity() {
      return commodity;
   }

   public void setCommodity(Commodity commodity) {
      this.commodity = commodity;
   }

   public int getNum() {
      return num;
   }

   public void setNum(int num) {
      this.num = num;
   }

   public BigDecimal getSubtotal() {
      return subtotal;
   }

   public void setSubtotal() {
      this.subtotal = commodity.getPrice().multiply(new BigDecimal(num));
   }

   @Override
   public String toString() {
      return "\n MyShopCartItemData{" +
            "checked=" + checked +
            ", commodity=" + commodity +
            ", num=" + num +
            ", subtotal=" + subtotal +
            '}';
   }



}
