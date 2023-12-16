package spring.mvc.samsung;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board") //�߰���� ���� board ������ /board�ۿ� ������ �ٸ���� ���� ��Ʈ�ѷ� ���θ����
public class BoardController {

	@GetMapping("/form1")
	public String form1()
	{
		return "board/writeForm"; //servlet-context���� WEB-INF �ڿ� ������
	}
	
	@PostMapping("/process")
	public ModelAndView process1(@RequestParam String name,
			@RequestParam String date,
			@RequestParam String gender,
			/*@RequestParam(defaultValue = "�ູ���Ϸ� ��������!") String msg) //value �ȳ־��*/
			/*required = true �� �⺻��, �׸��� ��� ������ �ȳ��� �Ϸ��� false*/
			@RequestParam(required = false)String msg,
			@RequestParam(defaultValue = "1") int currentPage) //int�� ����
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
			model.addAttribute("title","�����ϴ� �̹���");
			return "board/result2";
		}
}