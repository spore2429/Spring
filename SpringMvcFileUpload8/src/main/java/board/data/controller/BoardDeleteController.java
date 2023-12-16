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
			//비번이 맞으면 수정폼으로,틀린경우는 passfail로 이동
			
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
		 * //해당넘버에 해당하는 포토
		 * 
		 * //파일삭제 if(!photo.equals(null)) //no가 아닌경우만 삭제해주기 { String
		 * path=session.getServletContext().getRealPath("/WEB-INF/photo");
		 * 
		 * File file=new File(path+"\\"+photo); file.delete(); }
		 * 
		 * //db에서삭제 dao.deleteReboard(num); return "redirect:list"; }
		 */
}
