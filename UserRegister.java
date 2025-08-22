package com.example.demo.loginCredentials;

public class UserRegister {
    private String uname;
    private String uemail;
    private String upassword;

    // constructor
    public UserRegister() {}
    public UserRegister(String name, String email, String password) {
        this.uname = name;
        this.uemail = email;
        this.upassword = password;
    }

    // getters and setters
    public String getName() { return uname; }
    public void setName(String name) { this.uname = name; }

    public String getEmail() { return uemail; }
    public void setEmail(String email) { this.uemail = email; }

    public String getPassword() { return upassword; }
    public void setPassword(String password) { this.upassword = password; }
}