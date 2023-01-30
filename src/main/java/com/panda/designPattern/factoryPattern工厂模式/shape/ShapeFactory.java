package com.panda.designPattern.factoryPattern工厂模式.shape;


import org.apache.commons.lang.StringUtils;

public class ShapeFactory {
    public static  final String CIRCLE = "circle";
    public static  final String SQUARE = "square";


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
