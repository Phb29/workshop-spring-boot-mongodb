package com.nelioalves.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.nelioalves.workshopmongo.domain.Post;
import com.nelioalves.workshopmongo.domain.User;
import com.nelioalves.workshopmongo.dto.AuthorDTO;
import com.nelioalves.workshopmongo.dto.CommentDTO;
import com.nelioalves.workshopmongo.repository.PostRepository;
import com.nelioalves.workshopmongo.repository.UserRepository;
@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf= new SimpleDateFormat ("dd/MM/yyyy"); 
		sdf.setTimeZone(TimeZone.getTimeZone("GNT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();

		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		
		Post p1 =new Post(null,  null, "oi mundo","olá",new AuthorDTO(bob));
		
		CommentDTO c1 = new CommentDTO("Boa viagem mano!", null,new AuthorDTO(alex));
		
		p1.getComments().addAll(Arrays.asList(c1));
		
		
		
		
		
		postRepository.saveAll(Arrays.asList(p1));
		
		maria.getPosts().addAll(Arrays.asList(p1));
		userRepository.save(maria);
		
	}

}
