package com.harxsh.cloud.gateway;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallBackController {

    @GetMapping("userServiceFallBack")
    public ResponseEntity<String> userServiceFallBack() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("User service is taking longer than expected. Please try again later.");
    }

    @GetMapping("departmentServiceFallBack")
    public ResponseEntity<String> departmentServiceFallBack() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Department service is taking longer than expected. Please try again later.");
    }
}
