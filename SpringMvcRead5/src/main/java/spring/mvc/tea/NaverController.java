package spring.mvc.tea;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import model.data.dto.ShopDto;

@Controller
@RequestMapping("/naver")
public class NaverController {

	@GetMapping("/form1")
	public String from1()
	{
		return "day1010/form1";
	}
	
	@PostMapping("/read1")
	public ModelAndView read1(@RequestParam String name,
			@RequestParam String gender,@RequestParam String addr)
	{
		ModelAndView model=new ModelAndView();
		
		//모델넣기
		model.addObject("name", name);
		model.addObject("gender", gender);
		model.addObject("addr", addr);
		//포워드
		model.setViewName("day1010/result1");
		
		return model;
	}
	
	@GetMapping("/form2")
	public String from2()
	{
		return "day1010/form2";
	}
	
	
	
	@PostMapping("/read2")
	public String process(@ModelAttribute("dto") ShopDto dto)
	{

		return "day1010/result2";
	}
	
	@GetMapping("/form3")
	public String from3()
	{
		return "day1010/form3";
	}
	
	@PostMapping("/read3")
	/* 폼태그의 name이 key값으로 , 입력란은 value값으로...*/
	public ModelAndView read3(@RequestParam Map<String, String> map)
	{
		ModelAndView model=new ModelAndView();
		
		//모델넣기
		model.addObject("sang",map.get("sang"));
		model.addObject("color",map.get("color"));
		model.addObject("price",map.get("price"));
		model.addObject("image",map.get("image"));
		//포워드
		model.setViewName("day1010/result3");
		
		return model;
	}
	
	@GetMapping("/form4")
	public String uploadform1()
	{
		return "upload/uploadForm1";
	}
	
	@PostMapping("/upload1")
	
	public ModelAndView read1(
			@RequestParam String title,
			@RequestParam MultipartFile photo,
			HttpSession session) //realPath
	{
		ModelAndView model=new ModelAndView();
		
		//업로드할 실제경로구하기
		String path=session.getServletContext().getRealPath("/WEB-INF/image");
		String fileName=photo.getOriginalFilename(); //업로드된 파일명
		
		//현재날짜와 시간이용해서 파일명에 저장
		SimpleDateFormat sdf=new SimpleDateFormat("yyyymmddHHss");
		
		
		if(!fileName.equals(""))
		{
			fileName=sdf.format(new Date())+"_"+fileName;
		
		
		//path에 업로드
		try {
			photo.transferTo(new File(path+"\\"+fileName));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else {
			
			fileName="no"; //업로드 안 할 경우
	}
		
		model.addObject("fileName", fileName);
		model.addObject("title", title);
		model.addObject("path", path);
		
		model.setViewName("upload/uploadResult1");
		
		return model;
	}
	
	@GetMapping("/uploadform5")
	public String uploadform2()
	{
		return "upload/uploadForm2";
	}

	//여러개 업로드해서 2번결과창으로 이동
	@PostMapping("/upload2")
	
	public ModelAndView read2(
			@RequestParam String title,
			@RequestParam ArrayList<MultipartFile> photo, //담을곳
			HttpSession session) //realPath
	{
		ModelAndView model=new ModelAndView();
		
		//업로드할 실제경로구하기
		String path=session.getServletContext().getRealPath("/WEB-INF/image");

		//현재날짜와 시간이용해서 파일명에 저장
		SimpleDateFormat sdf=new SimpleDateFormat("yyyymmddHHss");
		
		ArrayList<String> files=new ArrayList<String>();
		
		//파일명담기
		for(MultipartFile f:photo)
		{
			String fileName=sdf.format(new Date())+"_"+f.getOriginalFilename(); //멀티파트파일에 파일이름담음
			files.add(fileName); //파일들에 파일이름을 담음
			
			//업로드
			try {
				f.transferTo(new File(path+"\\"+fileName));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		model.addObject("files", files);
		model.addObject("title", title);
		model.addObject("path", path);
		
		model.setViewName("upload/uploadResult2");
		
		return model;
	}
}
