package board.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import answer.data.AnswerDao;
import answer.data.AnswerDto;
import spring.mvc.reboard.BoardDao;
import spring.mvc.reboard.BoardDto;

@Controller
public class BoardContentController {

@Autowired
BoardDao dao;

@Autowired
AnswerDao adao;
	
	@GetMapping("/board/content")
	
	public String detailpage(Model model,
			@RequestParam int num,@RequestParam int currentPage)
	{

		//��ȸ������
		dao.updateReadCount(num);
		
		BoardDto dto=dao.getBoardData(num);
		
		//num�� �ش��ϴ� ����� db���� �����ͼ� ������
		List<AnswerDto> alist=adao.getAnswerList(num);
		
		//���� �������� �Ѱܾ� �ϹǷ�
		model.addAttribute("acount", alist.size());
		model.addAttribute("alist", alist);
		
		model.addAttribute("dto", dto);
		model.addAttribute("currentPage", currentPage);
		
		return "reboard/detailpage";
	}
}
