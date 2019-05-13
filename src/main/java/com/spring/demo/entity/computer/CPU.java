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
    private int price;

    @Column(name = "3d_score")
    private int score;

    @Column(name = "zhupin")
    private String zhupin;

    @Column(name = "zuidaruipin")
    private String zuidaruipin;

    @Column(name = "caozaleixing")
    private String caozaleixing;

    @Column(name = "erjihuancun")
    private String erjihuancun;

    @Column(name = "hexinshuliang")
    private String hexinshuliang;

    @Column(name = "xianchengshu")
    private String xianchengshu;

    @Column(name = "src")
    private String src;


    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
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

    public String getCaozaleixing() {
        return caozaleixing;
    }

    public String getZhupin() {
        return zhupin;
    }

    public String getErjihuancun() {
        return erjihuancun;
    }

    public String getZuidaruipin() {
        return zuidaruipin;
    }

    public String getHexinshuliang() {
        return hexinshuliang;
    }

    public String getXianchengshu() {
        return xianchengshu;
    }

    public void setCaozaleixing(String caozaleixing) {
        this.caozaleixing = caozaleixing;
    }

    public void setErjihuancun(String erjihuancun) {
        this.erjihuancun = erjihuancun;
    }

    public void setHexinshuliang(String hexinshuliang) {
        this.hexinshuliang = hexinshuliang;
    }

    public void setXianchengshu(String xianchengshu) {
        this.xianchengshu = xianchengshu;
    }

    public void setZhupin(String zhupin) {
        this.zhupin = zhupin;
    }

    public void setZuidaruipin(String zuidaruipin) {
        this.zuidaruipin = zuidaruipin;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
