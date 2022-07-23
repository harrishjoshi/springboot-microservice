package com.harxsh.user.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    private Long id;

    private String name;

    private String address;

    private String code;
}
