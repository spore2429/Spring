package spring.anno.ex6;

import org.springframework.stereotype.Component;

@Component
public class TestDao {

	public void insert(String irum)
	{
		System.out.println(irum+"�� db�� �߰���");
	}
	public void delete(String no)
	{
		System.out.println(no+"�� ����Ÿ ������");
	}
	public void select(String irum)
	{
		System.out.println(irum+"���� ������ ��� 20�� ������");
	}
}
