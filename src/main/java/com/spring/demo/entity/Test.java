package com.spring.demo.entity;

import javax.persistence.Entity;
import java.util.Arrays;

public class Test {

    private String name;
    private String instruct;
    private int s1[];

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstruct() {
        return instruct;
    }

    public void setInstruct(String instruct) {
        this.instruct = instruct;
    }

    public int[] getS1() {
        return s1;
    }

    public void setS1(int[] s1) {
        this.s1 = s1;
    }

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                ", instruct='" + instruct + '\'' +
                ", s1=" + Arrays.toString(s1) +
                '}';
    }

    public Test(String name, String instruct, int[] s1) {
        this.name = name;
        this.instruct = instruct;
        this.s1 = s1;
    }

    public Test() {
    }
}
