package com.panda.designPattern._05_prototypePattern.shape;

public class Square extends Shape{

    public Square() {
        type = "square";
    }

    public void draw() {
        System.out.println("draw square");
    }
}
