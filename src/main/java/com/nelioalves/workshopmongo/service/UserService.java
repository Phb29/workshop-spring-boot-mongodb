package com.nelioalves.workshopmongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.workshopmongo.domain.User;
import com.nelioalves.workshopmongo.repository.UserRepository;

@Service

public class UserService {
	@Autowired
	private UserRepository repo;
	public List<User> findAll(){
		return repo.findAll();
		
	}
	public User findById(String id) {
		User user= repo.findById(id).orElse(null);
		if(user==null) {
			throw new ObjectNotFoundExceptionexception("objeto nao encontrado");
	}
		return user;
	
	
		
	}

}
