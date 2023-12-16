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
		model.addAttribute("msg", "안녕하세요~!");
		return "result1";
	}
	

	@GetMapping("/school/myinfo")
	public String form_result2()
	{
		return "form_result2";
	}
	
	
	//get방식
	@GetMapping("/school/myschoolinfo")//첫번째방법 ex1) /shcool/myinfo/schoolinfo, 두번째방법 ex2) /school/schoolinfo form_result2에 action에는 school/을 제외한 나머지주소를 적는다
	public ModelAndView result2(String myname,String myschool,int mygrade,String myschooladdr)
	{
		
		ModelAndView mview=new ModelAndView();
		
		//request에 저장
		mview.addObject("name", myname);
		mview.addObject("school", myschool);
		mview.addObject("grade", mygrade);
		mview.addObject("schooladdr", myschooladdr);
		
		//포워드
		mview.setViewName("result2");
		return mview;
	}
	
	
	//post방식_dto
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
	
	
	//post방식 Map
	@GetMapping("/myshinsang")
	public String form_result4()
	{
		return "form_result4";
	}
	
	@PostMapping("/myshinsanginfo") //myshinsang 경로를 myshinsanginfo로 새롭게 정의
	public ModelAndView read3(@RequestParam Map<String, String> map)
	{
		ModelAndView model=new ModelAndView();
		
		String name=map.get("name");
		String age=map.get("age");
		String bloodtype=map.get("bloodtype");
		String addr=map.get("addr");
		
		String data="이름: "+name+"\t나이: "+age+"세\t혈액형: "+bloodtype+"형\t주소: "+addr;
		
		model.addObject("data", data);
		
		model.setViewName("result4");
		
		return model;
	}
}
