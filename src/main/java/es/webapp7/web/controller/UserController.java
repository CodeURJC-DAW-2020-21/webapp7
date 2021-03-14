package es.webapp7.web.controller;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.net.URI;
import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import es.webapp7.web.repository.UserRepository;
import es.webapp7.web.model.User;

public class UserController {

    @Autowired
	private UserRepository users;

    @GetMapping("/")
	public Collection<User> getUsers() {
		return users.findAll();
	}

	@GetMapping("/{id}")
	public User getUser(@PathVariable long id) {

		return users.findById(id).orElseThrow();
	}

	@PostMapping("/")
	public ResponseEntity<User> createUser(@RequestBody User user) {

		users.save(user);

		URI location = fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();

		return ResponseEntity.created(location).body(user);
	}

	@PutMapping("/{id}")
	public User replaceUser(@PathVariable long id, @RequestBody User newUser) {

		users.findById(id).orElseThrow();

		newUser.setId(id);
		users.save(newUser);
			
		return newUser;
	}

	@DeleteMapping("/{id}")
	public User deleteUser(@PathVariable long id) {

		User user = users.findById(id).orElseThrow();

		user.deleteById(id);
		
		return user;
	}
    
}
