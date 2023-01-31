package com.panda.designPattern._02_abstractFactoryPattern;

import com.panda.designPattern._02_abstractFactoryPattern.color.ColorFactory;
import com.panda.designPattern._02_abstractFactoryPattern.shape.ShapeFactory;

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
