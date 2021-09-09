package com.lexical.foodapp.controller;

import com.lexical.foodapp.model.UserModel;
import com.lexical.foodapp.response.HandlerResponse;
import com.lexical.foodapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", produces = {"application/json"})
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "", produces = {"application/json"})
    public String getUser() {
        return "This is route test";
    }

    @PostMapping(value = "/register", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public void register(HttpServletRequest request, HttpServletResponse response,
                         @Valid @NotNull @ModelAttribute("fullname") String name,
                         @Valid @NotNull @ModelAttribute("email") String email,
                         @Valid @NotNull @ModelAttribute("password") String password) throws IOException {

        List<UserModel> userExists = userService.getUserByEmail(email);

        if (userExists.size() > 0) {
            HandlerResponse.responseBadRequest(response, "99", "User already registered");
        } else {
            try {
                UserModel userModel = new UserModel();
                userModel.setFullName(name);
                userModel.setEmail(email);
                userModel.setPassword(password);

                userService.createUser(userModel);
                HandlerResponse.responseSuccessCreated(response, "USER CREATED");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
