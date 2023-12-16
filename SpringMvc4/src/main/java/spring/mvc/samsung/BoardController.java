package spring.mvc.samsung;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board") //중간경로 띄우기 board 빼도됨 /board밖에 사용못함 다른경로 쓸시 컨트롤러 새로만들기
public class BoardController {

	@GetMapping("/form1")
	public String form1()
	{
		return "board/writeForm"; //servlet-context에서 WEB-INF 뒤에 다지움
	}
	
	@PostMapping("/process")
	public ModelAndView process1(@RequestParam String name,
			@RequestParam String date,
			@RequestParam String gender,
			/*@RequestParam(defaultValue = "행복한하루 보내세요!") String msg) //value 안넣어도됨*/
			/*required = true 가 기본값, 항목이 없어도 에러가 안나게 하려면 false*/
			@RequestParam(required = false)String msg,
			@RequestParam(defaultValue = "1") int currentPage) //int도 가능
	{
		ModelAndView model=new ModelAndView();
		
		model.addObject("name",name);
		model.addObject("date",date);
		model.addObject("gender",gender);
		model.addObject("msg", msg);
		model.addObject("currentPage", currentPage);
		
		model.setViewName("board/result");
		
		return model;
	}
	
	@GetMapping("/result2")
		public String result2(Model model)
		{
			model.addAttribute("myimg1", "../image/bin.jpg");
			model.addAttribute("title","좋아하는 이미지");
			return "board/result2";
		}
}
