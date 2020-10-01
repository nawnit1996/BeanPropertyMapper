package com.beanmaper.test;

import com.beanmapper.annotation.ColumnMapping;

public class TestPojo {
   @ColumnMapping("firstName")
    public String name;

   @ColumnMapping("rollNumber")
    public int roll;

   public long longNumber;

   @ColumnMapping("doubleNumber")
   public double doub;

   public  NestedClass nestedClass ;

    public TestPojo(String name, int roll, long longNumber, double doub, NestedClass nestedClass) {
        this.name = name;
        this.roll = roll;
        this.longNumber = longNumber;
        this.doub = doub;
        this.nestedClass = nestedClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public long getLongNumber() {
        return longNumber;
    }

    public void setLongNumber(long longNumber) {
        this.longNumber = longNumber;
    }

    public double getDoub() {
        return doub;
    }

    public void setDoub(double doub) {
        this.doub = doub;
    }

    public NestedClass getNestedClass() {
        return nestedClass;
    }

    public void setNestedClass(NestedClass nestedClass) {
        this.nestedClass = nestedClass;
    }
}
