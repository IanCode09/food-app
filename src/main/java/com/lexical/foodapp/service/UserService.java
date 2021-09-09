package com.lexical.foodapp.service;

import com.lexical.foodapp.model.UserModel;
import com.lexical.foodapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserModel createUser(UserModel userModel) {
        return userRepository.save(userModel);
    }

    public List<UserModel> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
