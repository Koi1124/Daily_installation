package com.spring.demo.entity.test;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "person")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Person {

    @Id
    @GeneratedValue(generator="jpa-uuid")
    private String id;
    @NotEmpty(message = "昵称不能为空")
    @Column(nullable = false,length = 20,name = "name")
    private String name;
    @NotEmpty(message = "邮箱不能为空")
    @Column(nullable = false,length = 100,name = "email")
    private String email;
    @NotEmpty(message = "密码不能为空")
    @Column(nullable = false,length = 20,name = "password")
    private String password;
    @NotEmpty(message = "性别不能为空")
    @Column(nullable = false,length = 2,name = "sex")
    private String sex;

    public Person() {}

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }
}
