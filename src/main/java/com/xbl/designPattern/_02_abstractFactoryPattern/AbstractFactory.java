package com.xbl.designPattern._02_abstractFactoryPattern;

import com.xbl.designPattern._02_abstractFactoryPattern.color.Color;
import com.xbl.designPattern._02_abstractFactoryPattern.shape.Shape;

public interface AbstractFactory {
    Color chooseColor(String color);
    Shape createShape(String shape);
}
