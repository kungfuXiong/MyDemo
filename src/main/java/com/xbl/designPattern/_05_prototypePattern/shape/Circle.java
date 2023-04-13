package com.xbl.designPattern._05_prototypePattern.shape;

public class Circle extends Shape{

    public Circle() {
        type = "circle";
    }

    public void draw() {
        System.out.println("draw circle");
    }
}
