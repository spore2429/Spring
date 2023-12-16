package spring.mvc.quiz;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.data.dto.FormDto;

@Controller
public class QuizController {
	

	@GetMapping("/ilike/movie")

	public String result1(Model model)
	{
		model.addAttribute("msg", "�ȳ��ϼ���~!");
		return "result1";
	}
	

	@GetMapping("/school/myinfo")
	public String form_result2()
	{
		return "form_result2";
	}
	
	
	//get���
	@GetMapping("/school/myschoolinfo")//ù��°��� ex1) /shcool/myinfo/schoolinfo, �ι�°��� ex2) /school/schoolinfo form_result2�� action���� school/�� ������ �������ּҸ� ���´�
	public ModelAndView result2(String myname,String myschool,int mygrade,String myschooladdr)
	{
		
		ModelAndView mview=new ModelAndView();
		
		//request�� ����
		mview.addObject("name", myname);
		mview.addObject("school", myschool);
		mview.addObject("grade", mygrade);
		mview.addObject("schooladdr", myschooladdr);
		
		//������
		mview.setViewName("result2");
		return mview;
	}
	
	
	//post���_dto
	@GetMapping("/shop/ipgo")
	public String form_result3()
	{
		return "form_result3";
	}
	
	@PostMapping("/shop/shopipgo")
	public ModelAndView read2(@ModelAttribute FormDto dto)
	{
		ModelAndView model=new ModelAndView();
		
		model.addObject("dto", dto);
		
		model.setViewName("result3");
		
		return model;
	}
	
	
	//post��� Map
	@GetMapping("/myshinsang")
	public String form_result4()
	{
		return "form_result4";
	}
	
	@PostMapping("/myshinsanginfo") //myshinsang ��θ� myshinsanginfo�� ���Ӱ� ����
	public ModelAndView read3(@RequestParam Map<String, String> map)
	{
		ModelAndView model=new ModelAndView();
		
		String name=map.get("name");
		String age=map.get("age");
		String bloodtype=map.get("bloodtype");
		String addr=map.get("addr");
		
		String data="�̸�: "+name+"\t����: "+age+"��\t������: "+bloodtype+"��\t�ּ�: "+addr;
		
		model.addObject("data", data);
		
		model.setViewName("result4");
		
		return model;
	}
}
