package com.nelioalves.workshopmongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.workshopmongo.domain.Post;
import com.nelioalves.workshopmongo.repository.PostRepository;

@Service

public class PostService {
	@Autowired
	private PostRepository repo;
		
	
	public Post findById(String id) {
		Post user= repo.findById(id).orElse(null);
		if(user==null) {
			throw new ObjectNotFoundExceptionexception("objeto nao encontrado");
	}
		return user;
	}
	}
	
	
	