package com.nasr.shape.polygon;

import com.nasr.shape.Polygon;

public class Triangle extends Polygon {
    @Override
    public double calPerimeter() {
        return 0;
    }

    @Override
    public double calArea() {
        return 0;
    }

    @Override
    public void draw() {
        System.out.println("Triangle: " + "side1: " + sides[0] + "side2: " + sides[1] + "side3: " + sides[2]);
    }

    boolean isEquilateral() {
        double side1 = sides[0];
        for (double side : sides) {
            if (side != side1)
                return false;
        }
        return true;
    }
}
