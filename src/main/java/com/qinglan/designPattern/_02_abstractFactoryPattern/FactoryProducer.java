package com.qinglan.designPattern._02_abstractFactoryPattern;

import com.qinglan.designPattern._02_abstractFactoryPattern.color.ColorFactory;
import com.qinglan.designPattern._02_abstractFactoryPattern.shape.ShapeFactory;

public class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("shape")){
            return new ShapeFactory();
        }else if (choice.equalsIgnoreCase("color")){
            return new ColorFactory();
        }
        return null;
    }
}
