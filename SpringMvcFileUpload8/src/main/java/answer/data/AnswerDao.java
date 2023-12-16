package answer.data;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AnswerDao implements AnswerDaoInter {

	@Autowired
	SqlSession session;
	
	@Override
	public void insertAnswer(AnswerDto dto) {
		// TODO Auto-generated method stub
		session.insert("InsertOfReAnswer", dto);
	}

	@Override
	public List<AnswerDto> getAnswerList(int num) {
		// TODO Auto-generated method stub
		return session.selectList("SelectNumOfReAnswer", num);
	}

	@Override
	public void deleteAnswer(int idx) {
		// TODO Auto-generated method stub
		session.delete("DeleteOfReAnswer", idx);
	}

	@Override
	public int getCheckPass(int idx, String pass) {
		// TODO Auto-generated method stub 
		//�ϳ��� ���ϵǸ� �����ְ� �����°��� Ÿ���� �ٸ��� object
		HashMap<String, Object> map=new HashMap<String, Object>();
		
		map.put("idx", idx);
		map.put("pass", pass);
		
		return session.selectOne("PassCheckPassOfAnswer", map);
	}



}
