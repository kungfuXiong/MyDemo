package com.qinglan.designPattern._05_prototypePattern;

import com.qinglan.designPattern._05_prototypePattern.shape.Shape;

/**
 * 深浅拷贝区分
 */
public class test {
    public static void main(String[] args) {
        ShapeCache.loadCache();

        Shape clone = ShapeCache.getClone(1);
        System.out.println(clone.getType());
        clone.draw();

        Shape clone1 = ShapeCache.getClone(2);
        System.out.println(clone1.getType());
        clone1.draw();


    }
}
