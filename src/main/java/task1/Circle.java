package task1;

import main.Shape;

public class Circle implements Shape {
    private double radius;

    public Circle() {
        radius = 1;
    }

    public Circle(double r) {
        radius = r;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }

    public double getRadius() {
        return radius;
    }

    public double S() {
        return Math.PI * radius * radius;
    }

    public double P() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void draw() {

    }
}
