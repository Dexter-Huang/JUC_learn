package com.example.tikatest.controller;

import com.example.tikatest.entity.User;
import com.example.tikatest.service.IUserService;
import com.example.tikatest.utils.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * ============控制器入口============
 */
@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {
    @Resource
    private IUserService userService;

    @GetMapping("/test")
    public ApiResponse test(@RequestBody User user) {
        log.info("业务：user.name: {}", user.getName());
        Map<String, String> result = new HashMap<>(2);
        result.put("code", "200");
        int i  = 1;
        return ApiResponse.success(result);
    }

    @PostMapping("/test1")
    public ApiResponse test1(@RequestBody User user) throws InterruptedException {
        log.info("业务：user.name: {}", user.getName());
        userService.insertTest1(user);
        return ApiResponse.success();
    }

    @PostMapping("/test2")
    public ApiResponse test2(@RequestBody User user) throws InterruptedException {
        log.info("业务：user.name: {}", user.getName());
        userService.insertTest2(user);
        return ApiResponse.success();
    }
}
