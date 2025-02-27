package com.example.crudparser.domain.dto;

public class UserRequestDto {
    private String id;
    private String name;
    private String password;

    public UserRequestDto(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
