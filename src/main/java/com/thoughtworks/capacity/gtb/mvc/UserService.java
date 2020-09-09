package com.thoughtworks.capacity.gtb.mvc;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
  private Map<Integer, User> userMap = new HashMap<>();
    private static Integer curId = 1;

    public UserService() {
        userMap.put(1, new User(1, "Tom", "12345", "tom@qq.com"));
    }
    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }

    public void addUser(User user) {

        user.setId(curId++);
        userMap.put(user.getId(),user);
    }
}
