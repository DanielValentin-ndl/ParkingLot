package org.parkinglotapp.parkinglotapp.common;


public class UserDto {
    String name;
    String email;

    public UserDto(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

}