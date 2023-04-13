package com.xbl.designPattern._04_builderPattern.item.food;

public class VegBurger extends Food {
    public String name() {
        return "蔬菜汉堡";
    }

    @Override
    public float price() {
        return 15f;
    }
}
