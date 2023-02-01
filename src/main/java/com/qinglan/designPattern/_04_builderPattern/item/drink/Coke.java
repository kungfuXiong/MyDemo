package com.qinglan.designPattern._04_builderPattern.item.drink;

public class Coke extends Drink{
    public String name() {
        return "可口可乐";
    }

    @Override
    public float price() {
        return 10f;
    }
}
