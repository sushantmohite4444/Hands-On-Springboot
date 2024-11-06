package springAOP.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import springAOP.Entity.Student;

@Repository
public interface DaoInterfaceJPA extends JpaRepositoryImplementation<Student, Integer> {
		
	//use save() for update
		List<Student> findByNameContainingOrLnameContaining(String namekeyword ,String lnamekeyword);
		List<Student> findByname(String name); // Attribute Should start with Lower case letter
		List<Student> findBylname(String name);// method Signature must be same like "findBy(name of field (attribute))"
		
		List<Student> findByidGreaterThan(int i);
		
		
		//get list of student who has id 1,52,102
		
		@Query("SELECT s FROM Student s WHERE s.id IN (:ids)")
		List<Student> getStudents(@Param("ids") List<Integer> ids);
	
		

}
