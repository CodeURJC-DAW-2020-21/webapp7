package es.webapp7.web.library.model;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import java.util.List;


@Entity
public class User {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String name;
	private String email;
	private String password;

	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;


	public User() {
	}

	public User(String name, String email, String encodedPassword, String... roles) {
		this.name = name;
		this.password = encodedPassword;
		this.email = email;
		this.roles = List.of(roles);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEncodedPassword() {
		return password;
	}

	public void setEncodedPassword(String encodedPassword) {
		this.password = encodedPassword;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
    
}



