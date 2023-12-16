package answer.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.mvc.reboard.BoardDao;



@Controller
public class AnswerController {

	@Autowired
	AnswerDao dao;
	
	@Autowired
	BoardDao bdao;
	
	@PostMapping("/board/ainsert")
	public String insertAnswer(@ModelAttribute AnswerDto dto,
			@RequestParam int num,
			@RequestParam int currentPage)
	{

		dao.insertAnswer(dto);
		bdao.updateMinusReadcount(num);
		
		return "redirect:content?num="+dto.getNum()+"&currentPage="+currentPage;
	}
	
	
	
}
