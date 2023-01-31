package com.panda.designPattern._04_builderPattern.item;

import com.panda.designPattern._04_builderPattern.packing.Packing;

public interface Item {
    public String name();
    public Packing packing();
    public float price();
}
