package com.harxsh.department.controller;

import com.harxsh.department.entity.Department;
import com.harxsh.department.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("department/api/v1")
@RequiredArgsConstructor
@Slf4j
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping("create")
    public Department saveDeparment(@RequestBody Department department) {
        log.info("Inside create method of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("{departmentId}")
    public Department findByDepartmentId(@PathVariable Long departmentId) {
        log.info("Inside getById method of DepartmentController");
        return departmentService.findByDepartmentId(departmentId);
    }

    @GetMapping("find-all")
    public List<Department> findAll() {
        log.info("Inside findAll method of DepartmentController");
        return departmentService.findAll();
    }
}
