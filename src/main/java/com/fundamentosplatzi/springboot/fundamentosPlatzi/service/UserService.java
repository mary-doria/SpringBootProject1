package com.fundamentosplatzi.springboot.fundamentosPlatzi.service;

import com.fundamentosplatzi.springboot.fundamentosPlatzi.entity.User;
import com.fundamentosplatzi.springboot.fundamentosPlatzi.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    private final Log LOG= LogFactory.getLog(UserService.class);



    private UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Transactional

    public void saveTransactional(List<User> users){
        users.stream()
                .peek(user -> LOG.info("Usuaruio Insertadi:" + user))
                .forEach(user -> userRepository.save(user));
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();

    }
}
