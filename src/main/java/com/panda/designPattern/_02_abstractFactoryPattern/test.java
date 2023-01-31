package com.panda.designPattern._02_abstractFactoryPattern;

import com.panda.designPattern._02_abstractFactoryPattern.color.Color;
import com.panda.designPattern._02_abstractFactoryPattern.shape.Shape;

public class test {
    public static void main(String[] args) {
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");

        AbstractFactory colorFactory = FactoryProducer.getFactory("COlor");

        Shape square = shapeFactory.createShape("Square");

        Color red = colorFactory.chooseColor("Red");

        square.draw();

        red.draw();

        Shape square1 = shapeFactory.createShape("circle");

        Color red1 = colorFactory.chooseColor("green");

        square1.draw();

        red1.draw();


    }
}
