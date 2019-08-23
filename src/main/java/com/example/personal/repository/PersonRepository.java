package com.example.personal.repository;

import com.example.personal.domain.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface PersonRepository extends CrudRepository<Person, Integer> {

    Person getById(int id);
    ArrayList <Person> findByDepartmentId(int id);
}



