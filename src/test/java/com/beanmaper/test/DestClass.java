package com.beanmaper.test;

public class DestClass {
    private String firstName;
    private int rollNumber;
    private Double doubleNumber;
    private InnerDestClass inner= new InnerDestClass();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public Double getDoubleNumber() {
        return doubleNumber;
    }

    public void setDoubleNumber(Double doubleNumber) {
        this.doubleNumber = doubleNumber;
    }

    public InnerDestClass getInner() {
        return inner;
    }

    public void setInner(InnerDestClass inner) {
        this.inner = inner;
    }
}
