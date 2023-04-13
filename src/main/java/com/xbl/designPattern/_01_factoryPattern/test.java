package com.xbl.designPattern._01_factoryPattern;

import com.xbl.designPattern._01_factoryPattern.shape.Shape;
import com.xbl.designPattern._01_factoryPattern.shape.ShapeFactory;

public class test {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape circle = shapeFactory.createShape("cIrcle");

        circle.draw();

        Shape square = shapeFactory.createShape("SQUare");

        square.draw();
    }
}
