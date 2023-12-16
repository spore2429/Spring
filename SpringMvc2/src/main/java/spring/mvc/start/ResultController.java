package spring.mvc.start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResultController {

	//@GetMapping("/apple/list.do") //list�ڿ� .do�� �ٸ� Ȯ���ڸ� ������ ��ȣ���
	@GetMapping("/apple/list")
	public String result1(Model model)
	{
		model.addAttribute("name", "�ø�����");
		model.addAttribute("country", "�̱�");
		return "result1";
	}
	
	@GetMapping("/banana/insert")
	public ModelAndView banana()
	{
		//ModelAndView �� request�� �����ϱ� ���� Model��
		//������ �ϱ����� View�� ���ĳ��� Ŭ�����Դϴ�.
		ModelAndView mview=new ModelAndView();
		
		//request�� ����
		mview.addObject("java", 88);
		mview.addObject("spring", 99);
		
		//�������� jsp��������
		mview.setViewName("result2");
		
		return mview; 
	}
	
	@GetMapping("/orange/delete")
	public ModelAndView orange()
	{
		ModelAndView mview=new ModelAndView();
		
		mview.addObject("name", "�̼���");
		mview.addObject("price", "3000000��");
		mview.addObject("color", "���");
	
		mview.setViewName("result3");
		
		return mview; 
	}
	
	@GetMapping("/shop/detail")
	public String resImage()
	{
		
		return "result4";
	}
	
	@GetMapping("/board/insert/data")
	public String imageImage()
	{
		
		return "result5";
	}
	
}
