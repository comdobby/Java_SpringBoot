package com.example.demo.dto.user;

public class User {
    private String name;
    private Integer age;

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
}
