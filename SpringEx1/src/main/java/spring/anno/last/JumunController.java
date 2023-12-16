package spring.anno.last;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JumunController {
   
   @Autowired
   ShopInter shopinter;
   
   int cnt=10;
   String name="ȫ����";
   
   public void insertJumun(String sang,int price,String color)
   {
      shopinter.insertSangpum(sang, price, color);
      System.out.println(name+"����\t"+cnt+"���� �ֹ���");
   }
   
   public void deleteJumun(String num)
   {
      shopinter.deleteSangpum(num);
   }
   
   public void selectJumun(String sang, int price, String color)
   {
      System.out.println("�ֹ���: "+name);
      shopinter.selectShop(sang, price, color);
      System.out.println("�ֹ�����: "+cnt);
   }
}