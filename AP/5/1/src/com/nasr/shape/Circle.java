package com.nasr.shape;

public class Circle implements Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }


    @Override
    public double calPerimeter() {
        return 2 * 3.14 * radius;
    }

    @Override
    public double calArea() {
        return 3.14 * radius * radius;
    }

    @Override
    public void draw() {

    }
}
