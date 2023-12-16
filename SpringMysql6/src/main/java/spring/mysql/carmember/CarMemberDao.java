package spring.mysql.carmember;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarMemberDao implements CarMemberInter {

	
	@Autowired
	private SqlSession session;  //Àü´ÞÀÚ
	
	@Override
	public int getTotalCount() {
		
		return session.selectOne("getTotalCountOfCarMember");
	}

	@Override
	public List<CarMemberDto> getAllCarMembers() {
		
		return session.selectList("getAllListOfCarMember");
	}

	@Override
	public void insert(CarMemberDto dto) {
		
		session.selectOne("insertOfCarMember",dto);
	}

	@Override
	public void delete(String num) {
		
		session.selectOne("deleteOfCarMember",num);
	}

	@Override
	public CarMemberDto getCarMemberData(String num) {
		
		return session.selectOne("getDataOfCarMember",num);
	}

	@Override
	public void update(CarMemberDto dto) {
		
		session.selectOne("updateOfCarMember",dto);
	}

	/*
	 * //select-list public List<CarMemberDto> getAllCarMembers() {
	 * 
	 * return session.selectList("getAllListOfCarMember"); }
	 * 
	 * //insert public void insert(CarMemberDto dto) {
	 * session.selectOne("insertOfCarMember",dto); }
	 * 
	 * //delete public void delete(String num) {
	 * session.selectOne("deleteOfCarMember",num); }
	 * 
	 * //select-num public CarMemberDto getCarMemberData(String num) {
	 * 
	 * return session.selectOne("getDataOfCarMember",num); }
	 * 
	 * //update public void update(CarMemberDto dto) {
	 * session.selectOne("updateOfCarMember",dto); }
	 */

}
