package spring.mysql.carmember;

import java.util.List;

public interface CarMemberInter {

	public int getTotalCount();
	public List<CarMemberDto> getAllCarMembers();
	public void insert(CarMemberDto dto);
	public void delete(String num);
	public CarMemberDto getCarMemberData(String num);
	public void update(CarMemberDto dto);
	//insert
	//allselect
	//getdata
	//update
	//delete
}
