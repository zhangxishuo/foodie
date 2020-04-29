package com.imooc.enums;

public enum Sex {

    woman(0, "女"),
    man(1, "男"),
    secret(2, "保密");

    public final Integer type;

    public final String value;

    Sex(int type, String value) {
        this.type = type;
        this.value = value;
    }
}
