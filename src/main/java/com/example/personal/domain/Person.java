package com.example.personal.domain;

import javax.persistence.*;

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String surname;
    private int age;
    private String email;

    @JoinColumn(name = "positionId")
    @ManyToOne
    private Position position;

    @JoinColumn(name = "departmentId")
    @ManyToOne
    private Department department;

    public Person() {
    }

    public Person(String name, String surname, int age, String email, Position position, Department department) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.position = position;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
