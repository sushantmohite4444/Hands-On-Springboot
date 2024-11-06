package com.example.demo.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserserviceImpl;

@RestController
public class RESTAPIcontroller {

	@Autowired
	UserserviceImpl userservice;
	
	
	
	@RequestMapping("/{id}")
	public  ResponseEntity<User> senddata(@PathVariable("id") int id) {
		User ut = userservice.getUser(id);
		return (ut ==null)? ResponseEntity.of(Optional.empty()): ResponseEntity.of(Optional.of(ut));
	}
	@RequestMapping("/")
	public ResponseEntity< List<User> > senddata() {		

		List<User> ut = userservice.getUsers();
		
	if(ut.isEmpty() == true) {
	//	return	ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	return ResponseEntity.of(Optional.empty());
	}
	return ResponseEntity.of(Optional.of(ut));
	}
	
	@PostMapping("/postdata")
	public ResponseEntity<User>  postdata(@RequestBody User ut ) {
//		System.out.println(ut.getId());
//		System.out.println(ut.getName());
//		System.out.println(ut.getLastname());
		
		 
		return ResponseEntity.status(HttpStatus.CREATED).body(userservice.saveUser(ut)) ;
		
	}
	
	@DeleteMapping("/delete/{id}")
	public Integer delete(@PathVariable("id")  int id) {

		 
		return userservice.deleteUser(id);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<User> Update(@RequestBody User obj,@PathVariable int id){

		return ResponseEntity.status(HttpStatus.CREATED).body(userservice.updateUser( id,obj )) ;
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<User>  Update(@RequestBody User obj){
		
		

		return ResponseEntity.status(HttpStatus.CREATED).body(userservice.updateUser(obj.getId() ,obj));
		
	}
	
	
	
	
	@PutMapping(path ="/update",produces = "application/json",consumes ="application/xml" )
	public ResponseEntity<User>  Update1(@RequestBody User obj){
		
		

		return ResponseEntity.status(HttpStatus.CREATED).body(userservice.updateUser(obj.getId() ,obj));
		
	}
	
	
	
	
	
	
	
	
	

}
