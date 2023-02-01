package com.panda.designPattern._04_builderPattern.item.food;

import com.panda.designPattern._04_builderPattern.item.Item;
import com.panda.designPattern._04_builderPattern.packing.Bottle;
import com.panda.designPattern._04_builderPattern.packing.Packing;
import com.panda.designPattern._04_builderPattern.packing.Wrapper;

public abstract class Food implements Item {
    public Packing packing() {
        return new Wrapper();
    }

    public float price() {
        return 0;
    }
}
