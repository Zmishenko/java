package main;

public class Shape implements Comparable<Shape> {

    private double perimetr = 0;

    public Shape(double perimetr) {
        this.perimetr = perimetr;
    }

    public Shape() {
    }

    public double getP(){

        return perimetr;
    }

    @Override
    public int compareTo(Shape o) {
        return (int)(this.getP() - o.getP());

    }
}

