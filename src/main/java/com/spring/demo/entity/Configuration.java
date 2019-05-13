package com.spring.demo.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ttzj_configuration")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Configuration {

    @Id
    @GeneratedValue(generator="jpa-uuid")
    private String configurationId;

    @Column(nullable = false,name = "userName")
    private String userName;

    @Column(nullable = false,name = "configurationName")
    private String configurationName;

    @Column(nullable = false,name = "instruct")
    private String instruct;

    @Column(nullable = false,name = "gpuName")
    private String gpuName;

    @Column(nullable = false,name = "cpuName")
    private String cpuName;

    @Column(nullable = false,name = "hddName")
    private String hddName;

    @Column(nullable = false,name = "memoryName")
    private String memoryName;

    @Column(nullable = false,name = "motherBoardName")
    private String motherBoardName;

    @Column(nullable = false,name = "powerSupplyName")
    private String powerSupplyName;

    @Column(nullable = false,name = "ssdName")
    private String ssdName;

    @Column(nullable = false,name = "gpuImg")
    private String gpuImg;

    @Column(nullable = false,name = "cpuImg")
    private String cpuImg;

    @Column(nullable = false,name = "hddImg")
    private String hddImg;

    @Column(nullable = false,name = "memoryImg")
    private String memoryImg;

    @Column(nullable = false,name = "motherBoardImg")
    private String motherBoardImg;

    @Column(nullable = false,name = "powerSupplyImg")
    private String powerSupplyImg;

    @Column(nullable = false,name = "ssdImg")
    private String ssdImg;

    public String getConfigurationId() {
        return configurationId;
    }

    public void setConfigurationId(String configurationId) {
        this.configurationId = configurationId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getConfigurationName() {
        return configurationName;
    }

    public void setConfigurationName(String configurationName) {
        this.configurationName = configurationName;
    }

    public String getInstruct() {
        return instruct;
    }

    public void setInstruct(String instruct) {
        this.instruct = instruct;
    }

    public String getGpuName() {
        return gpuName;
    }

    public void setGpuName(String gpuName) {
        this.gpuName = gpuName;
    }

    public String getCpuName() {
        return cpuName;
    }

    public void setCpuName(String cpuName) {
        this.cpuName = cpuName;
    }

    public String getHddName() {
        return hddName;
    }

    public void setHddName(String hddName) {
        this.hddName = hddName;
    }

    public String getMemoryName() {
        return memoryName;
    }

    public void setMemoryName(String memoryName) {
        this.memoryName = memoryName;
    }

    public String getMotherBoardName() {
        return motherBoardName;
    }

    public void setMotherBoardName(String motherBoardName) {
        this.motherBoardName = motherBoardName;
    }

    public String getPowerSupplyName() {
        return powerSupplyName;
    }

    public void setPowerSupplyName(String powerSupplyName) {
        this.powerSupplyName = powerSupplyName;
    }

    public String getSsdName() {
        return ssdName;
    }

    public void setSsdName(String ssdName) {
        this.ssdName = ssdName;
    }

    public String getGpuImg() {
        return gpuImg;
    }

    public void setGpuImg(String gpuImg) {
        this.gpuImg = gpuImg;
    }

    public String getCpuImg() {
        return cpuImg;
    }

    public void setCpuImg(String cpuImg) {
        this.cpuImg = cpuImg;
    }

    public String getHddImg() {
        return hddImg;
    }

    public void setHddImg(String hddImg) {
        this.hddImg = hddImg;
    }

    public String getMemoryImg() {
        return memoryImg;
    }

    public void setMemoryImg(String memoryImg) {
        this.memoryImg = memoryImg;
    }

    public String getMotherBoardImg() {
        return motherBoardImg;
    }

    public void setMotherBoardImg(String motherBoardImg) {
        this.motherBoardImg = motherBoardImg;
    }

    public String getPowerSupplyImg() {
        return powerSupplyImg;
    }

    public void setPowerSupplyImg(String powerSupplyImg) {
        this.powerSupplyImg = powerSupplyImg;
    }

    public String getSsdImg() {
        return ssdImg;
    }

    public void setSsdImg(String ssdImg) {
        this.ssdImg = ssdImg;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "configurationImg='" + configurationId + '\'' +
                ", userName='" + userName + '\'' +
                ", configurationName='" + configurationName + '\'' +
                ", instruct='" + instruct + '\'' +
                ", gpuName='" + gpuName + '\'' +
                ", cpuName='" + cpuName + '\'' +
                ", hddName='" + hddName + '\'' +
                ", memoryName='" + memoryName + '\'' +
                ", motherBoardName='" + motherBoardName + '\'' +
                ", powerSupplyName='" + powerSupplyName + '\'' +
                ", ssdName='" + ssdName + '\'' +
                ", gpuImg='" + gpuImg + '\'' +
                ", cpuImg='" + cpuImg + '\'' +
                ", hddImg='" + hddImg + '\'' +
                ", memoryImg='" + memoryImg + '\'' +
                ", motherBoardImg='" + motherBoardImg + '\'' +
                ", powerSupplyImg='" + powerSupplyImg + '\'' +
                ", ssdImg='" + ssdImg + '\'' +
                '}';
    }
}
