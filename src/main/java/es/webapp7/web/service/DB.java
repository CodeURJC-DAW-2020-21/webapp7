package es.webapp7.web.service;

import es.webapp7.web.model.User;
import es.webapp7.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.PostConstruct;


@Service
public class DB {
    /**Inyectamos el repositorio UserRepository */
    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init(){
        userRepository.save(new User("a@gmail.com","a","1234"));
        userRepository.save(new User("b@gmail.com","b", "1234"));
        userRepository.save(new User("c@gmail.com","c", "1234"));
        userRepository.save(new User("d@gmail.com","d", "1234"));
    }


}
