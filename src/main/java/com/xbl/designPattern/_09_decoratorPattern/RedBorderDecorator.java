package com.xbl.designPattern._09_decoratorPattern;

import com.xbl.designPattern._09_decoratorPattern.shape.Shape;

public class RedBorderDecorator extends Decorator{

    public RedBorderDecorator(Shape initialShape) {
        super(initialShape);
    }

    @Override
    public void draw() {
        super.draw();
        setRedBorder(this.initialShape);
    }

    public void setRedBorder(Shape shape){
        System.out.println("Border Red");
    }
}
