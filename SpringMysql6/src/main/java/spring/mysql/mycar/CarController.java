package spring.mysql.mycar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CarController {

	@Autowired
	MyCarDao dao;
	
	@GetMapping("/kakao/list")
	public String list(Model model)
	{
		//dao로부터 총개수가져오기
		int totalCount=dao.getTotalCount();
		//목록가져오기
		List<MyCarDto> list=dao.getAllCars();
	
		//request에 저장
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
		
		return "car/carlist";
	}
	
	//insert폼
	@GetMapping("/kakao/writeform") //carlist onclick주소
	public String carform()
	{
		return "car/writeform";
	}
	
	//insert
	@PostMapping("/kakao/write") //action 주소
	public String insert(@ModelAttribute("dto") MyCarDto dto)
	{
		 dao.insertCar(dto);
			
		return "redirect:list";
	}
	
	//delete
	@GetMapping("/kakao/delete") 
	public String delete(String num)
	{
		 dao.deleteCar(num);
			
		return "redirect:list";
	}
	
	/*
	 * //update폼
	 * 
	 * @GetMapping("/kakao/updateform") public String updateform(String num,Model
	 * model) { MyCarDto dto =dao.getCarData(num); model.addAttribute("dto", dto);
	 * return "car/updateform"; }
	 */
	
	@GetMapping("/kakao/updateform") 
	public ModelAndView updateform(String num)
	{
		ModelAndView model=new ModelAndView();
		MyCarDto dto =dao.getCarData(num);
		model.addObject("dto", dto);
		model.setViewName("car/updateform");
		
		return model;
	}
	
	//update
	@PostMapping("/kakao/update") 
	public String update(@ModelAttribute("dto") MyCarDto dto)
	{
		 dao.updateCar(dto);
			
		return "redirect:list";
	}
}
