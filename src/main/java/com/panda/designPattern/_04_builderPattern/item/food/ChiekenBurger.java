package com.panda.designPattern._04_builderPattern.item.food;

public class ChiekenBurger extends Food {
    public String name() {
        return "鸡肉汉堡";
    }

    @Override
    public float price() {
        return 20f;
    }
}
