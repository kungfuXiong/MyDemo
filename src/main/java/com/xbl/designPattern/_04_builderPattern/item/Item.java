package com.xbl.designPattern._04_builderPattern.item;

import com.xbl.designPattern._04_builderPattern.packing.Packing;

public interface Item {
    public String name();
    public Packing packing();
    public float price();
}
