package com.thoughtworks.capacity.gtb.mvc.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.thoughtworks.capacity.gtb.mvc.exception.UserAlreadyExistsException;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import com.thoughtworks.capacity.gtb.mvc.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@RequestBody @Valid User user) throws UserAlreadyExistsException {
        userService.addUser(user);
    }

    @GetMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public User login(@RequestParam
                          @NotNull(message = "用户名不为空")
                          @Pattern(message ="用户名不合法", regexp = "^[A-Za-z_0-9]{3,10}$")
                                  String username,
                          @NotNull(message = "密码是不为空")
                          @Size(message ="密码不合法", max=12,min=5)
                                  String password){
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        return userService.login(user);
    }

}
