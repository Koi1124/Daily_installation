package com.spring.demo.entity.computer;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "ttzj_ssd")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class SSD {
    @Id
    @GeneratedValue(generator="jpa-uuid")
    private String ssdId;

    @Column(nullable = false, name = "ssdName")
    private String ssdName;

    @Column(name = "src")
    private String src;

    @Column(name = "price")
    private String price;

    @Column(name = "score")
    private double score;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
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

    public String getSsdId() {
        return ssdId;
    }

    public String getSsdName() {
        return ssdName;
    }

    public void setSsdId(String ssdId) {
        this.ssdId = ssdId;
    }

    public void setSsdName(String ssdName) {
        this.ssdName = ssdName;
    }
}
