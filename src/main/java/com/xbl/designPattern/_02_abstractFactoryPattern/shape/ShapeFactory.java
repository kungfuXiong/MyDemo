package com.xbl.designPattern._02_abstractFactoryPattern.shape;


import com.xbl.designPattern._02_abstractFactoryPattern.AbstractFactory;
import com.xbl.designPattern._02_abstractFactoryPattern.color.Color;
import org.apache.commons.lang.StringUtils;

public class ShapeFactory implements AbstractFactory {
    public static  final String CIRCLE = "circle";
    public static  final String SQUARE = "square";


    public Color chooseColor(String color) {
        return null;
    }

    public Shape createShape(String shapeName){
        if (StringUtils.isNotBlank(shapeName)) {
            if (CIRCLE.equalsIgnoreCase(shapeName)){
                return new Circle();
            } else if (SQUARE.equalsIgnoreCase(shapeName)) {
                return new Square();
            }
        }else {
            return null;
        }
        return null;
    }
}
