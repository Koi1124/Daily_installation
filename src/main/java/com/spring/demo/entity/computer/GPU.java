package com.spring.demo.entity.computer;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "ttzj_gpu")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class GPU {
    @Id
    @GeneratedValue(generator="jpa-uuid")
    private String gpuId;

    @Column(nullable = false, name = "gpuName")
    private String gpuName;

    @Column(name = "price")
    private int price;

    @Column(name = "3d_score")
    private int score;

    @Column(name = "src")
    private String src;

    public void setScore(int score) {
        this.score = score;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getSrc() {
        return src;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }


    public int getScore() {
        return score;
    }

    public String getGpuId() {
        return gpuId;
    }

    public String getGpuName() {
        return gpuName;
    }

    public void setGpuId(String gpuId) {
        this.gpuId = gpuId;
    }

    public void setGpuName(String gpuName) {
        this.gpuName = gpuName;
    }

}
