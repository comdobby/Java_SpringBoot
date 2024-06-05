package com.example.demo.dto.user;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(nullable = false, length = 25, name = "name")
    private String name;
    private Integer age;

    protected User() {}

    public User(String name, Integer age) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException(String.format("This is a wrong name(%s).", name));
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Long getId() {
        return id;
    }

    public void updateName(String name) {
        this.name = name;
    }
}
