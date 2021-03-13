package es.webapp7.web.service;

import es.webapp7.web.model.User;
import es.webapp7.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.PostConstruct;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init(){
        User u1 = new User("email1@gmail.com","a","1234");
        User u2 = new User("email2@gmail.com","b", "1234");
        User u3 = new User("email3@gmail.com","c","1234");
        User u4 = new User("email4@gmail.com","d", "1234");
        

        this.save(u1);
        this.save(u2);
    }

    public void save(User user){
        userRepository.save(user);
    }


    public Optional<User> findUserByEmail(String email){
        return userRepository.findById(email);
    }
}
