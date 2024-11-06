package com.example.demo.dal;

 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	
	public List<User> findByname(String name);
	
	@Query("select u from User u where u.lastname=:lastname and u.name=:name")
	public List<User> findByNameandlastname(
		@Param("name")String name, 
		@Param("lastname") String lastname);

}
