package com.spring.demo.entity.computer;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "ttzj_p_s")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class PowerSupply {
    @Id
    @GeneratedValue(generator="jpa-uuid")
    private String p_sId;

    @Column(nullable = false, name = "p_sName")
    private String p_sName;

    @Column(name = "src")
    private String src;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private int price;

    @Column(name = "score")
    private double score;

    public void setScore(double score) {
        this.score = score;
    }

    public int getPrice() {
        return price;
    }

    public double getScore() {
        return score;
    }

    public String getDescription() {
        return description;
    }

    public String getP_sId() {
        return p_sId;
    }

    public String getP_sName() {
        return p_sName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setP_sId(String p_sId) {
        this.p_sId = p_sId;
    }

    public void setP_sName(String p_sName) {
        this.p_sName = p_sName;
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
}
