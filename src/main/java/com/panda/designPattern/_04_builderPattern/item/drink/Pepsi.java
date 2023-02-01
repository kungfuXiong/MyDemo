package com.panda.designPattern._04_builderPattern.item.drink;

public class Pepsi extends Drink{
    public String name() {
        return "百事可乐";
    }

    @Override
    public float price() {
        return 10.5f;
    }
}
