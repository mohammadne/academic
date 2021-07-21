package com.nasr.shape;

public abstract class Polygon implements Shape {
    public Double[] sides;

    void getSides(Double... sides) {
        this.sides = sides;
    }
}
