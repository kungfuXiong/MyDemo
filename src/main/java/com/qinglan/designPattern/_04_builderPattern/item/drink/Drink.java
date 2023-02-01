package com.qinglan.designPattern._04_builderPattern.item.drink;

import com.qinglan.designPattern._04_builderPattern.item.Item;
import com.qinglan.designPattern._04_builderPattern.packing.Bottle;
import com.qinglan.designPattern._04_builderPattern.packing.Packing;

public abstract class Drink implements Item {

    public float price() {
        return 0;
    }

    public Packing packing() {
        return new Bottle();
    }
}
