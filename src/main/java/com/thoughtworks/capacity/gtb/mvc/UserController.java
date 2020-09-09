package com.thoughtworks.capacity.gtb.mvc;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
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
    public User login(@RequestParam @Valid String username,String password){
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        return userService.login(user);
    }

}
