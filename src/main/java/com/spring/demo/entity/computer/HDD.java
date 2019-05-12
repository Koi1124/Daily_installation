package com.spring.demo.entity.computer;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "ttzj_hdd")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class HDD {
    @Id
    @GeneratedValue(generator="jpa-uuid")
    private String hddId;

    @Column(nullable = false, name = "hddName")
    private String hddName;

    @Column(name = "src")
    private String src;

    @Column(name = "price")
    private String price;

    @Column(name = "score")
    private double score;

    @Column(name = "description")
    private String description;

    public void setScore(double score) {
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getSrc() {
        return src;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public String getHddId() {
        return hddId;
    }

    public String getHddName() {
        return hddName;
    }

    public void setHddId(String hddId) {
        this.hddId = hddId;
    }

    public void setHddName(String hddName) {
        this.hddName = hddName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
