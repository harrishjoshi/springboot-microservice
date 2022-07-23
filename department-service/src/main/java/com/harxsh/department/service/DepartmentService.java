package com.harxsh.department.service;

import com.harxsh.department.entity.Department;
import com.harxsh.department.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        log.info("Inside save method of DepartmentService");
        return departmentRepository.save(department);
    }

    public Department findByDepartmentId(Long departmentId) {
        log.info("Inside getById method of DepartmentService");
        return departmentRepository.findById(departmentId).orElse(null);
    }

    public List<Department> findAll() {
        log.info("Inside getAll method of DepartmentService");
        return departmentRepository.findAll();
    }
}
