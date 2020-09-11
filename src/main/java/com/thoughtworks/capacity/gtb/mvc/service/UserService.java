package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.exception.UserNotFoundException;
import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.exception.UserAlreadyExistsException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
  private Map<String, User> userMap = new HashMap<>();

    public UserService() {
        userMap.put("Tom", new User(1, "Tom", "12345", "tom@qq.com"));
    }
    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }

    public void addUser(User user) throws UserAlreadyExistsException {
        if(userMap.containsKey(user.getUsername())) {
            throw new UserAlreadyExistsException("用户已存在");
        }
        else {
            user.setId(userMap.size());
            userMap.put(user.getUsername(), user);
        }
    }

    public User login(User user) {
        if (userMap.containsKey(user.getUsername())) {
            User loginUser = userMap.get(user.getUsername());
            if (loginUser.getPassword().equals(user.getPassword())) {
                return loginUser;
            } else {
                throw new UserNotFoundException("密码错误");
            }
        }
        throw new UserNotFoundException("用户名错误");
    }
}
