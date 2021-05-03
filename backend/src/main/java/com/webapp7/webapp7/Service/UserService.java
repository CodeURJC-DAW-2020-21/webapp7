package com.webapp7.webapp7.Service;

import com.webapp7.webapp7.model.User;
import com.webapp7.webapp7.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    public List<User> findByRol(String rol){return userRepository.findByRol(rol);}

    public User findByName(String name) {
        return userRepository.selectByName(name);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void delete(long id) {
        userRepository.deleteById(id);
    }

    public List<User> findAllUsers(){
       return userRepository.findAllUsers();
    }

    public User selectByEmail(String email) {
        User u = userRepository.selectByEmail(email);
        return u;
    }
    public Optional<User> selectById(long id) {
        return Optional.empty();
    }


}
