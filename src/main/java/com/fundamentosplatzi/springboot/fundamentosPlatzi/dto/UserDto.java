package com.fundamentosplatzi.springboot.fundamentosPlatzi.dto;

public class UserDto {

    private long id;
    private String name;
    private String birthday;



    private String email;



    public UserDto(long id, String name, String birthday, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
    }
    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }


}
