package answer.data;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.mvc.reboard.BoardDao;


@RestController
public class AnswerRestController {

	@Autowired
	AnswerDao dao;
	
	@Autowired
	BoardDao bdao;
	
	@GetMapping("/board/adelete") //0,1인지 넘기므로 Integer
	public HashMap<String, Integer> deleteAnswer(@RequestParam int idx,
			@RequestParam int num,
			@RequestParam String pass)
	{
		int check=dao.getCheckPass(idx, pass);
		
		if(check==1)
		{
			
			dao.deleteAnswer(idx);
			bdao.updateMinusReadcount(num);
			
		}
			
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		map.put("check", check);

		return map;
		
	}
}
