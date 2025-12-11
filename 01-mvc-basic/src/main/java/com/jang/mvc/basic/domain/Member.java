package com.jang.mvc.basic.domain;

public record Member (
    Long id,
    String name,
    String email,
    int age) {

    public Member {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be null or blank");
        }
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }

    public static Member create(String name, String email, int age) {
        return new Member(null, name, email, age);
    }

    public Member withId(Long id) {
        return new Member(id, this.name, this.email, this.age);
    }

    public Member update(String name, String email, int age) {
        return new Member(this.id, name, email, age);
    }

}
