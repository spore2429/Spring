package spring.anno.last;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShopMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext anno1=new ClassPathXmlApplicationContext("annoContext4.xml");
		JumunController jumun=(JumunController)anno1.getBean("jumunController");
		
		jumun.insertJumun("배게", 30000, "흰색");
		jumun.deleteJumun("1");
		jumun.selectJumun("아령", 15000, "핑크");
		
	}

}
