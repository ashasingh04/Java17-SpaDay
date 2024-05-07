package org.launchcode.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class User {
//    private int id;
//    private  static int nextId = 1;
    @NotBlank
    @Size(min=5, max=15,message = "UserName must be between 5 and 15 characters.")
    private  String username;
    @Email(message = "Invalid email. Try again.")
    private String email;
    @NotNull
    @Size(min=6, message = "Password must be at least 6 characters long.")
    private String password;
    @NotNull(message = "Password do not match.")
    @Size(min=6, message = "Password must be at least 6 characters long.")
    private String verifyPassword;
//    private LocalDate dateAdded;
    public  User(){

    }
    public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
//        this.id = nextId;
//        this.dateAdded = LocalDate.now();
//        nextId++;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword();
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }
    //    public LocalDate getDateAdded() {
//        return dateAdded;
//    }
//
//    public int getId() {
//        return id;
//    }

    @Override
    public String toString() {
        return username;
    }

    private void checkPassword(){
        if(password != null && verifyPassword != null){
            if(!password.equals(verifyPassword)){
               verifyPassword = null;
            }
        }
    }
}
