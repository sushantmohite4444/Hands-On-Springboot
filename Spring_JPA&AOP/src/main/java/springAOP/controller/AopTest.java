package springAOP.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import springAOP.Entity.Student;
import springAOP.Service.StudentService;

@Controller
public class AopTest {
	
	@Autowired
	StudentService stdservice;
	
	@RequestMapping("/saveStudent")
	public String getpage() {
		
		Student s=new Student( );
		s.setLname("mohite");
		s.setName("sush");
		stdservice.saveStudent(s);
		return "update";
		
	}
	
	@RequestMapping("/getStudent")
	public String Aopmethod() {
		stdservice.getstudent(List.of(1,52,102));
		return "update";
	}
	
	@RequestMapping("/keyword")
	public String keywordSerch() {
		stdservice.keywordSerch("z");
		return "update";
	}
}
