package com.qinglan.designPattern._02_abstractFactoryPattern;

import com.qinglan.designPattern._02_abstractFactoryPattern.shape.Shape;
import com.qinglan.designPattern._02_abstractFactoryPattern.shape.ShapeFactory;

public class AbstractFactoryPattern {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape circle = shapeFactory.createShape("cIrcle");

        circle.draw();

        Shape square = shapeFactory.createShape("SQUare");

        square.draw();
    }
}
