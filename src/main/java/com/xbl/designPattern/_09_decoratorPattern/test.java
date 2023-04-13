package com.xbl.designPattern._09_decoratorPattern;

import com.xbl.designPattern._09_decoratorPattern.shape.Circle;

public class test {
    public static void main(String[] args) {
        Circle circle = new Circle();
//        Decorator decorator = new Decorator(circle);
        RedBorderDecorator redBorderDecorator = new RedBorderDecorator(circle);
        System.out.println("normal shape :");
        circle.draw();
        System.out.println("withBorder shape :");
        redBorderDecorator.draw();
    }
}
