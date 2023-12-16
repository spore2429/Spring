package spring.mvc.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //json���� ó���ؼ� �������� ��� ajax������
public class JsonTest2Controller {

	@GetMapping("/list2")
	public Map<String, String> list2()
	{
		Map<String, String> map=new HashMap<String, String>();
		
		map.put("name", "�̺�");
		map.put("color", "�ϴû�");
		map.put("price", "60000");
		
		return map;
	}
	
	@GetMapping("/list4")
	public Map<String, Object> list4(@RequestParam String name) //�̸��� �Է��ؾ� �����̳����Ƿ� �̸��� �ѱ�
	{
		List<PhotoDto> list=new ArrayList<PhotoDto>();
		
		list.add(new PhotoDto("�α�","minq.jpg" ));
		list.add(new PhotoDto("ȣ����","hosugi.jpg" ));
		list.add(new PhotoDto("��������","pro.jpg" ));
		list.add(new PhotoDto("�����","movie.jpg" ));
		list.add(new PhotoDto("���ŵ���","moon.png" ));
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("name", "���¸޴�");
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
