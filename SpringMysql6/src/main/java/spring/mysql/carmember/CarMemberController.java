package spring.mysql.carmember;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class CarMemberController {

	@Autowired
	CarMemberInter inter;
	
	@GetMapping("/member/list")
	public String memberStart(Model model)
	{
		//갯수가져오기
		int count=inter.getTotalCount();
		//목록가져오기
		List<CarMemberDto> list=inter.getAllCarMembers();
		
		//request에 저장
		model.addAttribute("count", count);
		model.addAttribute("list", list);
		
		return "carmember/memberlist";
	}
	
	//addform
	@GetMapping("/member/addform")
	public String addform()
	{
		return "carmember/addform";
	}
	
	//addaction
	@PostMapping("/member/add")
	public String add(@ModelAttribute CarMemberDto dto)
	{
		
		inter.insert(dto);
		
		return "redirect:list";
	}
	
	//delete
	@GetMapping("/member/delete")
	public String delete(String num)
	{
			
		inter.delete(num);
			
		return "redirect:list";
	}
	
	
	//updateform
	@GetMapping("/member/updateform")
	public ModelAndView updateform(String num)
	{
		ModelAndView model=new ModelAndView();
		CarMemberDto dto=inter.getCarMemberData(num);
		model.addObject("dto", dto);
		
		model.setViewName("carmember/updateform");
		return model;
	}
	
	//updateaction
	@PostMapping("/member/update")
	public String update(@ModelAttribute CarMemberDto dto)
	{
			
		inter.update(dto);
			
		return "redirect:list";
	}
	
}
