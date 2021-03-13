package es.webapp7.web.library.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import es.webapp7.web.library.repository.UserRepository;
import javax.annotation.PostConstruct;
import es.webapp7.web.library.model.User;


@Service
public class DB {
    @Autowired
	private UserRepository userRepository;
    
    @PostConstruct
	public void init()  {
    userRepository.save(new User("persona", "DJGDJFNDhola@gmail.com","1234", "USER"));
    }
}
