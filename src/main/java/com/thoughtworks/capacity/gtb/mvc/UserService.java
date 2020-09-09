package com.thoughtworks.capacity.gtb.mvc;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
  private Map<String, User> userMap = new HashMap<>();
    private static Integer curId = 1;

    public UserService() {
        userMap.put("Tom", new User(1, "Tom", "12345", "tom@qq.com"));
    }
    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }

    public void addUser(User user) {
        user.setId(curId++);
        userMap.put(user.getUsername(),user);
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
