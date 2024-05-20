package com.miguel.apibiblioteca.services.impl;

import com.miguel.apibiblioteca.models.User;
import com.miguel.apibiblioteca.repository.UserRepository;
import com.miguel.apibiblioteca.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll() ;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findById(Long id) {
            return userRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean existById(Long id) {
        return userRepository.existsById(id);
    }
}
