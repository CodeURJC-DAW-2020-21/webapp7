package com.webapp7.webapp7.Service;
import java.util.List;
import java.util.Optional;
import com.webapp7.webapp7.model.User;
import com.webapp7.webapp7.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService {
    @Autowired
    private UserRepository userrepository;
    public Optional<User> findById(long id) {
        return userrepository.findById(id);
    }


    public List<User> findAll() {
        return userrepository.findAll();
    }

    public void  save (User user) {
         userrepository.save(user);
    }
    public void delete(long id) {
        userrepository.deleteById(id);
    }


    public UserService(UserRepository userRepository) {
        this.userrepository = userRepository;
    }

    public User selectByEmail(String email) {
        User u = userrepository.selectByEmail(email);
        return u;
    }
    public Optional<User> selectById(long id) {
        return Optional.empty();
    }
}
