package spring.anno.last;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JumunController {
   
   @Autowired
   ShopInter shopinter;
   
   int cnt=10;
   String name="홍성경";
   
   public void insertJumun(String sang,int price,String color)
   {
      shopinter.insertSangpum(sang, price, color);
      System.out.println(name+"님이\t"+cnt+"개를 주문함");
   }
   
   public void deleteJumun(String num)
   {
      shopinter.deleteSangpum(num);
   }
   
   public void selectJumun(String sang, int price, String color)
   {
      System.out.println("주문자: "+name);
      shopinter.selectShop(sang, price, color);
      System.out.println("주문갯수: "+cnt);
   }
}