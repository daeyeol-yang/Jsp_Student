package com.nhnacademy.student;

import java.time.LocalDateTime;

public class Student {
    private String id;

    private String name;

    private Gender gender;

    private int age;

    private LocalDateTime createdAt;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
