package com.spring.demo.entity.computer;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "ttzj_m_b")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class MotherBoard {
    @Id
    @GeneratedValue(generator="jpa-uuid")
    private String m_bId;

    @Column(nullable = false, name = "m_bName")
    private String m_bName;

    @Column(name = "price")
    private int price;

    @Column(name = "src")
    private String src;

    @Column(name = "score")
    private double score;

    @Column(name = "description")
    private String description;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

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

    public String getM_bId() {
        return m_bId;
    }

    public String getM_bName() {
        return m_bName;
    }

    public void setM_bId(String m_bId) {
        this.m_bId = m_bId;
    }

    public void setM_bName(String m_bName) {
        this.m_bName = m_bName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
