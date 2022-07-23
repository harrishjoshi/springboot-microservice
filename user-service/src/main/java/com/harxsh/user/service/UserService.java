package com.harxsh.user.service;

import com.harxsh.user.entity.User;
import com.harxsh.user.repository.UserRepository;
import com.harxsh.user.vo.Department;
import com.harxsh.user.vo.ResponseTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    @Autowired
    private final RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside addUser method of UserService");
        return userRepository.save(user);
    }

    public List<User> findAll() {
        log.info("Inside findAll method of UserService");
        return userRepository.findAll();
    }

    public ResponseTemplate getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment method of UserService");
        ResponseTemplate responseTemplate = new ResponseTemplate();
        User user = userRepository.findById(userId).orElse(null);

        Department department = null;

        if (user != null) {
            department = restTemplate.getForObject(
                    "http://DEPARTMENT-SERVICE/department/api/v1/" + user.getDepartmentId(), Department.class
            );
        }

        responseTemplate.setUser(user);
        responseTemplate.setDepartment(department);

        return responseTemplate;
    }
}
