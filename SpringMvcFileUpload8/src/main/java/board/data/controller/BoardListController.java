package board.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import answer.data.AnswerDao;
import spring.mvc.reboard.BoardDao;
import spring.mvc.reboard.BoardDto;

@Controller
public class BoardListController {

	@Autowired
	BoardDao dao;
	
	@Autowired
	AnswerDao adao;
	
	@GetMapping("/board/list")
	public ModelAndView boardlist(
			@RequestParam(value = "currentPage", defaultValue = "1") int currentPage)
	{
		ModelAndView model=new ModelAndView();

		//����¡ó���� �ʿ��� ��������
		int totalCount=dao.getTotalCount(); //��ü����
		int totalPage; //�� ������
		int startPage; //���������� ������ ����������
		int endPage; //���������� ������ ��������
		int startNum; //db���� ������ ���� ���۹�ȣ(mysql�� ù���� 0,����Ŭ�� 1)
		int perPage=5; //���������� ������ ���� ����
		int perBlock=1; //�Ѻ����� ������ ������ ����
		
		//�������� 1�̶� ������ ������ 1������ �߰�(1+1=2�������� �ʿ�)
	  	totalPage=totalCount/perPage+(totalCount%perPage==0?0:1);
	  	
	  	//�������� �������� ����������
	  	//perBlock=5�ϰ��� ���������� 1~5 ����:1 ��:5
	  	//���������� 13  ����:11  ��:15
	  	startPage=(currentPage-1)/perBlock*perBlock+1;
	       
	  	endPage=startPage+perBlock-1;

	  	if (endPage > totalPage)
	         endPage = totalPage;
	  	
		//1������: 0,2������:5 3������:10....
		startNum=(currentPage-1)*perPage;
		
		//������������ �ʿ��� �Խñ� ��������
		List<BoardDto> list=dao.getPagingList(startNum, perPage);
		
		//list�� �� �ۿ� ��۰��� ǥ��
		for(BoardDto d:list)
		{
			d.setAcount(adao.getAnswerList(d.getNum()).size()); 
		}
		
		//������������ ������ ���۹�ȣ	
		int no=totalCount-(currentPage-1)*perPage;
		
		model.addObject("totalCount", totalCount);
		model.addObject("list", list); //��������� ����
		model.addObject("startPage", startPage);
		model.addObject("endPage", endPage);
		model.addObject("totalPage", totalPage);
		model.addObject("no", no);
		model.addObject("currentPage", currentPage);
		
		

		model.setViewName("reboard/boardlist");
		return model;
	}
	
	
}