package com.miguel.apibiblioteca.services;

import com.miguel.apibiblioteca.models.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    List<User> findAll();
    User save(User user);
    void deleteById(Long id);
    User findById(Long id);
    Boolean existById(Long id);
}
