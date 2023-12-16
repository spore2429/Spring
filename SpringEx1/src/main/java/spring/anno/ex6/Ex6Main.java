package spring.anno.ex6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex6Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext app=new ClassPathXmlApplicationContext("annoContext4.xml");
		
		MysqlController mysql1=(MysqlController)app.getBean("mysql");  //변수명 상관없음
		
		mysql1.myInsert("홍성경");
		mysql1.myDelete("3");
		mysql1.mySelect("홍성경");
	}

}
