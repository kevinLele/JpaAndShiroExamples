package com.kevin.examples.entity.enums;

/**
 * Created by Administrator on 11/1/2016.
 */
public enum SexEnum {
    MALE(0, "男"), FEMALE(1, "女");

    private final Integer value;
    private final String info;

    SexEnum(Integer value, String info) {
        this.value = value;
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public Integer getValue() {
        return value;
    }
}
