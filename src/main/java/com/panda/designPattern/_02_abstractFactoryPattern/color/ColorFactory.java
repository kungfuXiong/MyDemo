package com.panda.designPattern._02_abstractFactoryPattern.color;


import com.panda.designPattern._02_abstractFactoryPattern.AbstractFactory;
import com.panda.designPattern._02_abstractFactoryPattern.shape.Shape;
import org.apache.commons.lang.StringUtils;

public class ColorFactory implements AbstractFactory {
    public static  final String GREEN = "green";
    public static  final String RED = "red";


    public Color chooseColor(String shapeName){
        if (StringUtils.isNotBlank(shapeName)) {
            if (GREEN.equalsIgnoreCase(shapeName)){
                return new Green();
            } else if (RED.equalsIgnoreCase(shapeName)) {
                return new Red();
            }
        }else {
            return null;
        }
        return null;
    }

    public Shape createShape(String shape) {
        return null;
    }
}
