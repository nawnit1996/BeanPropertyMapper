package com.beanmaper.test;

public class NestedClass {
   // @ColumnMapping("inner.name")
    private String innerName;

    public String getInnerName() {
        return innerName;
    }

    public NestedClass(String innerName) {
        this.innerName = innerName;
    }

    public void setInnerName(String innerName) {
        this.innerName = innerName;
    }
}
