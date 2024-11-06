package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.dal.UserRepository;
import com.example.demo.entity.User;

@Service
public class UserserviceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User saveUser(User user) {
	return userRepository.save(user);
	}
	

	@Override
	public User updateUser(Integer id, User user) {

	     User u	=getUser(id);
	     u.setLastname(user.getLastname());
	     u.setName(user.getName()); 
	     
		return  saveUser(user);
	}

	@Override
	public User getUser(Integer id) {
		
		Optional  optional ;
		
		try{
		optional = userRepository.findById(id);
		return (User) optional.get();
		}
		catch (Exception e) {
			System.out.println("exception occurs at the time of getting optional.get()");
			e.printStackTrace();
			
			return null;
		}

	}

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public Integer deleteUser(Integer id) {
		
		userRepository.deleteById(id);
		return 0 ;
	}

	@Override
	public List<User> findByName(String str) {
		return userRepository.findByname(str);
	}


	@Override
	public List<User> findByNameandlastname(String name, String lastname) {
		
		return userRepository.findByNameandlastname(name, lastname);
	}

}
