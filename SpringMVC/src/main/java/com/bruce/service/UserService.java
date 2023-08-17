package com.bruce.service;

import com.bruce.pojo.User;
import com.springmvc.annotation.Service;

import java.util.List;
@Service
public interface UserService {

    List<User> findUsers(String name);
}
