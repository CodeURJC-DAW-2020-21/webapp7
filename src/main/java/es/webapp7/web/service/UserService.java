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
        User u1 = new User("p1@gmail.com","pericopalotes909","contraseña");
        User u2 = new User("yo@hotmail.com","XXXkillerG0D99XXX", "IAmVeryMature");

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
