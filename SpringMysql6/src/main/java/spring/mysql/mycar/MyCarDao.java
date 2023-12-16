package spring.mysql.mycar;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyCarDao {

	@Autowired
	private SqlSession session;  //������
	
	String namespace="spring.mysql.mycar.MyCarDao"; //��Ű�����
	
	public int getTotalCount()
	{
		return session.selectOne(namespace+".getTotalCount"); //id=sql��
	}
	
	//insert
	public void insertCar(MyCarDto dto)
	{
		session.insert("insertOfMyCar", dto);
	}
	
	//list
	public List<MyCarDto> getAllCars()
	{
		return session.selectList("getAllListOfMyCar");
	}
	
	//delete
	public void deleteCar(String num)
	{
		session.delete("deleteOfMyCar", num);
	}
	
	//getdata
	public MyCarDto getCarData(String num)
	{
		return session.selectOne("getDataOfMyCar", num);
	}
	
	//update
	public void updateCar(MyCarDto dto)
	{
		session.delete("updateOfMyCar", dto);
	}
}
