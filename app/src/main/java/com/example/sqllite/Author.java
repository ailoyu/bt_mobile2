package com.example.sqllite;

public class Author {

    private int id_author;
    private String name;
    private String address;
    private String email;

    public Author(int id_author, String name, String address, String email) {
        this.id_author = id_author;
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public Author() {
        this.id_author = 0;
        this.name = null;
        this.address = null;
        this.email = null;
    }

    public int getId_author() {
        return id_author;
    }

    public void setId_author(int id_author) {
        this.id_author = id_author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
