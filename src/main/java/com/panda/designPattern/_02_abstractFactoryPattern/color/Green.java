package com.panda.designPattern._02_abstractFactoryPattern.color;

import com.panda.designPattern._01_factoryPattern.shape.Shape;

public class Green implements Color {
    public void draw() {
        System.out.println("绿色");
    }
}
