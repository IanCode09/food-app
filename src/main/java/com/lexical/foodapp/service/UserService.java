package com.lexical.foodapp.service;

import com.lexical.foodapp.model.UserModel;
import com.lexical.foodapp.repository.UserRepository;
import com.lexical.foodapp.shared.dto.ProfileDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<UserModel> getUserById(int id) {
        Optional<UserModel> userExists = userRepository.findById(id);
        return userExists;
    }

    public ProfileDto getProfile(int userId) {
        Optional<UserModel> userExists = userRepository.findById(userId);
        if (userExists.isPresent()) {
            ProfileDto profile = new ProfileDto();
            profile.setFullName(userExists.get().getFullName());
            profile.setEmail(userExists.get().getEmail());

            return profile;
        } else {
            return null;
        }
    }

    public ProfileDto updateProfile(int userId, String fullName, String email) {
        Optional<UserModel> userExists = userRepository.findById(userId);

        if(userExists.isPresent()) {
            UserModel userModel = userExists.get();

            if (email != null && !email.isEmpty()) {
                userModel.setEmail(email);
            }

            if (fullName != null && !fullName.isEmpty()) {
                userModel.setFullName(fullName);
            }

            userRepository.save(userModel);

            ProfileDto profileDto = new ProfileDto();
            profileDto.setEmail(userModel.getEmail());
            profileDto.setFullName(userModel.getFullName());

            return profileDto;
        } else {
            return null;
        }
    }
}
