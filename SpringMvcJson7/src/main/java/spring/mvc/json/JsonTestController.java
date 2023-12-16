package spring.mvc.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonTestController {

	@GetMapping("/list1")
	@ResponseBody //json 처리후 브라우저로 출력(일반 컨트롤러 일경우) 아니면 @RestController
	public Map<String, String> list1()
	{
		Map<String, String> map=new HashMap<String, String>();
		
		map.put("name", "장순영");
		map.put("hp", "010-111-2222");
		map.put("addr", "수원시 장안구");
		
		
		return map;
	}
	
	@GetMapping("/list3")
	public @ResponseBody List<PhotoDto> list3()
	{
		List<PhotoDto> list=new ArrayList<PhotoDto>();
		
		list.add(new PhotoDto("bin","bin.jpg" ));
		list.add(new PhotoDto("oliver","oliver.jpg" ));
		list.add(new PhotoDto("pro","pro.jpg" ));
		list.add(new PhotoDto("movie","movie.jpg" ));
		list.add(new PhotoDto("moon","moon.png" ));
		
		return list;
	}
	
	
}
