package spring.anno.ex5;

import org.springframework.stereotype.Component;

@Component("kfruit") //id�� kfruit���� ���� @Component ������ KoreaFruit�� id
public class KoreaFruit implements Fruit {

	@Override
	public void writeFruitName() {
		// TODO Auto-generated method stub
		System.out.println("�ѱ������� ���ִ�");
	}

}
