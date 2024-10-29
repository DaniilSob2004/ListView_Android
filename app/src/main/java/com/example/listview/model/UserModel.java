package com.example.listview.model;

public class UserModel {
    private int idAvatar;
    private String name;
    private String surname;
    private int age;
    private String country;
    private String city;


    public UserModel() {}

    public UserModel(int idAvatar, String name, String surname, int age, String country, String city) {
        this.idAvatar = idAvatar;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.country = country;
        this.city = city;
    }


    public int getIdAvatar() {
        return idAvatar;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }


    public void setIdAvatar(int idAvatar) {
        this.idAvatar = idAvatar;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
