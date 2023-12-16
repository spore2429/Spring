package spring.anno.ex4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("logic") //id�� logic�� �ȴ� #���1
//("logic") @Component ���� #���2

public class LogicController {

	@Autowired
	//��Ȯ�� ���� ���̵�� ����_��ȣ���� �ִ°�쿡�� @Resourse(name="myDao")
	DaoInter daoInter;
	
	public LogicController(MyDao dao) {
		this.daoInter=dao;
	}
	
	//insert
	public void insert(String str)
	{
		daoInter.insertData(str);
	}
	
	//delete
	public void delete(String num)
	{
		daoInter.deleteData(num);
	}
}
