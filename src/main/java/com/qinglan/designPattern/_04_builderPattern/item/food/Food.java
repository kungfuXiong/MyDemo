package com.qinglan.designPattern._04_builderPattern.item.food;

import com.qinglan.designPattern._04_builderPattern.item.Item;
import com.qinglan.designPattern._04_builderPattern.packing.Packing;
import com.qinglan.designPattern._04_builderPattern.packing.Wrapper;

public abstract class Food implements Item {
    public Packing packing() {
        return new Wrapper();
    }

    public float price() {
        return 0;
    }
}
