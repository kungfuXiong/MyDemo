package com.panda.designPattern.factoryPattern工厂模式;

import com.panda.designPattern.factoryPattern工厂模式.shape.Shape;
import com.panda.designPattern.factoryPattern工厂模式.shape.ShapeFactory;

public class factoryPattern {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape circle = shapeFactory.createShape("cIrcle");

        circle.draw();

        Shape square = shapeFactory.createShape("SQUare");

        square.draw();
    }
}
