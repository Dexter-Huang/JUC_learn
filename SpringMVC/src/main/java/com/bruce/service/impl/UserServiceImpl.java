package com.bruce.service.impl;

import com.bruce.pojo.User;
import com.bruce.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    public List<User> findUsers(String name) {
        System.out.println("name:"+name);
        List<User> list = new ArrayList<User>();
        User user1 = new User();
        user1.setId(1);
        user1.setName("Bruce");
        user1.setPassword("123456");
        list.add(user1);
        return list;
    }
}
