package spring.mvc.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //json으로 처리해서 브라우저에 띄움 ajax만가능
public class JsonTest2Controller {

	@GetMapping("/list2")
	public Map<String, String> list2()
	{
		Map<String, String> map=new HashMap<String, String>();
		
		map.put("name", "이불");
		map.put("color", "하늘색");
		map.put("price", "60000");
		
		return map;
	}
	
	@GetMapping("/list4")
	public Map<String, Object> list4(@RequestParam String name) //이름을 입력해야 사진이나오므로 이름만 넘김
	{
		List<PhotoDto> list=new ArrayList<PhotoDto>();
		
		list.add(new PhotoDto("민규","minq.jpg" ));
		list.add(new PhotoDto("호스기","hosugi.jpg" ));
		list.add(new PhotoDto("선수끼리","pro.jpg" ));
		list.add(new PhotoDto("명장면","movie.jpg" ));
		list.add(new PhotoDto("문신돼지","moon.png" ));
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("name", "없는메뉴");
		map.put("photo", "5.jpg");
		
		for(PhotoDto dto:list)
		{
			if(name.equals(dto.getName()))
			{
				map.put("name", dto.getName());
				map.put("photo", dto.getPhoto());
			}
		}
		
		return map;
		
	}
}
