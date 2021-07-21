package com.nasr.shape.polygon;

import com.nasr.shape.Polygon;

public class Rectangle extends Polygon {
    @Override
    public double calPerimeter() {
        return 2 * (sides[0] + sides[1]);
    }

    @Override
    public double calArea() {
        return sides[0] * sides[1];
    }

    @Override
    public void draw() {
        double a = sides[0];
        double b = sides[1];
        if (a > b) {
            a = sides[1];
            b = sides[0];
        }
        System.out.println("Rectangle: width: " + a + " length: " + b);
    }

    boolean isSquare() {
        double side1 = sides[0];
        for (double side : sides) {
            if (side != side1)
                return false;
        }
        return true;
    }
}
