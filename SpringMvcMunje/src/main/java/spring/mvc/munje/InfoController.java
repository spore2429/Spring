package spring.mvc.munje;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import data.dto.InfoDto;

@Controller
public class InfoController {

	/*
	 * @GetMapping("/info/form") public String form2() { return "info/infoForm"; }
	 */
	
	@GetMapping("/info/form")
	public ModelAndView start()
	{
		ModelAndView model=new ModelAndView();
	
		model.setViewName("info/infoForm");
		
		return model;
	}
	
	@PostMapping("/info/result")
	public String process(@ModelAttribute("dto") InfoDto dto)
	{
		/*
		 * if(dto.getHobby()==null) dto.setHobby("¾øÀ½");
		 */
		return "info/infoWrite";
	}
	
	
}
