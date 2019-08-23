package com.example.personal.repository;

import com.example.personal.domain.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {
    Department findById(int id);
}
