package com.spring.demo.entity.computer;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "ttzj_memory")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Memory {
    @Id
    @GeneratedValue(generator="jpa-uuid")
    private String memoryId;

    @Column(nullable = false, name = "memoryName")
    private String memoryName;

    @Column(name = "src")
    private String src;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private int price;

    @Column(name = "score")
    private double score;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getMemoryId() {
        return memoryId;
    }

    public String getMemoryName() {
        return memoryName;
    }

    public void setMemoryId(String memoryId) {
        this.memoryId = memoryId;
    }

    public void setMemoryName(String memoryName) {
        this.memoryName = memoryName;
    }
}
