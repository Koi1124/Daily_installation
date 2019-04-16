package com.spring.demo.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "ttzj_user")
public class User {

    @Id
    private String name;
    @NotEmpty(message = "密码不能为空")
    @Column(nullable = false,length = 20,name = "password")
    private String password;
    @Column(name = "src")
    private String src;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

}
