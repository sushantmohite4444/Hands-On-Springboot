package springAOP.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springAOP.Dao.DaoInterfaceJPA;
import springAOP.Entity.Student;

@Service
public class StudentService {
	
	@Autowired
	DaoInterfaceJPA jpaObj;
	
	public Student saveStudent(Student std) {
		
		jpaObj.save(std);
		
		
		return std;
		
	}
	
	public List<Student> getstudent(List<Integer> val)
	{
//		da.findAll();
//		Optional<Student> stud=	da.findById(123);
//		List<Student> stud=	(List<Student>) jpaObj.findById(123).orElse(null);
		
//		List<Student> stud = new ArrayList<>();
//		jpaObj.findById(123).ifPresent(stud::add);
		
//		List<Student> stud=	da.findByname(name);
//		List<Student> stud=	da.findBylname(name);
//		List<Student> stud=	da.getStudents(val);
		List<Student> stud=	jpaObj.findByidGreaterThan(0);
		System.out.println(stud);
		for(Student std :stud) {
//			jpaObj.delete(std);   //delete
			//(or)
			std.setLname("mohite");
			jpaObj.save(std);   // update
			
		}

		return stud;
	}
	
	public List<Student> keywordSerch(String name) {
		
	List<Student>	stud =jpaObj.findByNameContainingOrLnameContaining(name,name);
	System.out.println(stud);
		return stud;

	}
	
	

}
