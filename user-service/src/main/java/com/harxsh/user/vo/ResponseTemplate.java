package com.harxsh.user.vo;

import com.harxsh.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplate {

    public ResponseTemplate(String error) {
        this.error = error;
    }

    private User user;

    private Department department;

    private String error;
}
