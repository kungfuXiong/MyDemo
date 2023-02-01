package com.qinglan.designPattern._05_prototypePattern;

import com.qinglan.designPattern._05_prototypePattern.shape.Circle;
import com.qinglan.designPattern._05_prototypePattern.shape.Shape;
import com.qinglan.designPattern._05_prototypePattern.shape.Square;

import java.util.Hashtable;

public class ShapeCache {

    private static  Hashtable<Integer, Shape> shapeMap = new Hashtable<Integer, Shape>();

    public static Shape getClone(int shapeId){
        Shape shape = shapeMap.get(shapeId);
        return (Shape) shape.clone();
    }

    public static void loadCache(){
        Circle circle = new Circle();
        circle.setId(1);
        shapeMap.put(circle.getId(),circle);

        Square square = new Square();
        square.setId(2);
        shapeMap.put(square.getId(),square);

    }
}
