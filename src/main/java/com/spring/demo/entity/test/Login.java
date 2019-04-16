package com.spring.demo.entity.test;

import javax.persistence.*;

@Entity
@Table(name="login")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String email;
    private String password;

    public Login(String email, String password) {
        this.email=email;
        this.password=password;
    }

    public Login() {
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
