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
		model.addAttribute("saying", "�ȳ��ϼ���~! �ø������Դϴ�.");
		return "quiz2";
	}
	
	@GetMapping("/hello.do")
	public String quiz3(Model model)
	{
		model.addAttribute("talking", "���ž�~");
		return "quiz3";
	}
	
	@GetMapping("/nice/hi")
	public String quiz4(Model model)
	{
		model.addAttribute("name", "�迵ȯ");
		model.addAttribute("age", "25");
		model.addAttribute("addr", "����� ������ ������");
		
		return "quiz4";
	}
}
