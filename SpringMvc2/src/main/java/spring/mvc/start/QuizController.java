package spring.mvc.start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuizController {

	@GetMapping("/happy")
	public String quiz1()
	{
		
		return "quiz1";
	}
	
	@GetMapping("/hello")
	public String quiz2(Model model)
	{
		model.addAttribute("saying", "안녕하세요~! 올리버쌤입니다.");
		return "quiz2";
	}
	
	@GetMapping("/hello.do")
	public String quiz3(Model model)
	{
		model.addAttribute("talking", "워씽씽~");
		return "quiz3";
	}
	
	@GetMapping("/nice/hi")
	public String quiz4(Model model)
	{
		model.addAttribute("name", "김영환");
		model.addAttribute("age", "25");
		model.addAttribute("addr", "서울시 강남구 논현동");
		
		return "quiz4";
	}
}
