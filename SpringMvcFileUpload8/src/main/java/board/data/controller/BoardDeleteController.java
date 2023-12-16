package board.data.controller;
import java.io.File;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import spring.mvc.reboard.BoardDao;
import spring.mvc.reboard.BoardDto;


@Controller
public class BoardDeleteController {

	@Autowired
	BoardDao dao;
	
		@GetMapping("/board/deletepassform")
		
		public ModelAndView deletepassform(
				@RequestParam String num,
				@RequestParam String currentPage)
		{
			ModelAndView model=new ModelAndView();
			model.addObject("num", num);
			model.addObject("currentPage", currentPage);
			
			model.setViewName("reboard/deletepassform");
			
			return model;
		
	}
		
		//delete
		@PostMapping("/board/delete")
		
		public ModelAndView deletepass(@RequestParam int num,
				@RequestParam int pass,@RequestParam int currentPage,
				HttpSession session)
		{
			String path=session.getServletContext().getRealPath("/WEB-INF/photo");
			System.out.println(path);
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
					
			String photo="";
			ModelAndView model=new ModelAndView();
			
			int passcheck=dao.getCheckPass(num, pass);
			//����� ������ ����������,Ʋ������ passfail�� �̵�
			
			if(passcheck==1)
			{
				String pre_photo=dao.getBoardData(num).getPhoto();
				
				String []pre_fName=pre_photo.split(",");
				for(String f:pre_fName)
				{
					File file=new File((path+"\\"+f));
					file.delete();
				}
				
				dao.deleteReboard(num); 
				
				model.setViewName("redirect:list");
			}else {
				
				model.setViewName("reboard/passfail");
			}
			return model;
		}
		
		
		/*
		 * @GetMapping("/board/delete") public String delete(@RequestParam int
		 * num,HttpSession session) { String photo=dao.getBoardData(num).getPhoto();
		 * //�ش�ѹ��� �ش��ϴ� ����
		 * 
		 * //���ϻ��� if(!photo.equals(null)) //no�� �ƴѰ�츸 �������ֱ� { String
		 * path=session.getServletContext().getRealPath("/WEB-INF/photo");
		 * 
		 * File file=new File(path+"\\"+photo); file.delete(); }
		 * 
		 * //db�������� dao.deleteReboard(num); return "redirect:list"; }
		 */
}
