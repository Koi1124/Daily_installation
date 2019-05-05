package com.spring.demo.entity.computer;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "ttzj_cpu")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class CPU {
    @Id
    @GeneratedValue(generator="jpa-uuid")
    private String cpuId;

    @Column(nullable = false, name = "cpuName")
    private String cpuName;

    @Column(name = "price")
    private String price;

    @Column(name = "3d_score")
    private int score;


    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public int getScore() {
        return score;
    }

    public String getCpuId() {
        return cpuId;
    }

    public String getCpuName() {
        return cpuName;
    }


    public void setCpuId(String cpuId) {
        this.cpuId = cpuId;
    }

    public void setCpuName(String cpuName) {
        this.cpuName = cpuName;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
