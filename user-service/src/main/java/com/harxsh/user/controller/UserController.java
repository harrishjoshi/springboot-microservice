package com.harxsh.user.controller;

import com.harxsh.user.entity.User;
import com.harxsh.user.service.UserService;
import com.harxsh.user.vo.ResponseTemplate;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user/api/v1")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping("add")
    public User saveUser(@RequestBody User user) {
        log.info("Inside addUser method of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("{userId}")
    // @CircuitBreaker(name = "userService", fallbackMethod = "userServiceFallBackMethod")
    public ResponseTemplate getUserWithDepartment(@PathVariable Long userId) {
        log.info("Inside getUserWithDepartment method of UserController");
        return userService.getUserWithDepartment(userId);
    }

    /*public ResponseTemplate userServiceFallBackMethod(Exception e) {
        log.info("User service fallback error: ", e);
        return new ResponseTemplate("User Service is taking longer than expected. Please try again later.");
    }*/

    @GetMapping("find-all")
    public List<User> findAll() {
        log.info("Inside findAll method of UserController");
        return userService.findAll();
    }
}
