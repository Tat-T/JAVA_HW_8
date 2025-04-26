package org.example.geometry.model;

public class Rhombus implements Shape {
    private double d1;
    private double d2;

    public Rhombus(double d1, double d2) {
        this.d1 = d1;
        this.d2 = d2;
    }

    @Override
    public double calculateArea() {
        return (d1 * d2) / 2;
    }
}
