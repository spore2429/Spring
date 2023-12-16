package spring.anno.ex5;

import org.springframework.stereotype.Component;

@Component("kfruit") //id를 kfruit으로 저장 @Component 없으면 KoreaFruit이 id
public class KoreaFruit implements Fruit {

	@Override
	public void writeFruitName() {
		// TODO Auto-generated method stub
		System.out.println("한국과일은 맛있다");
	}

}
