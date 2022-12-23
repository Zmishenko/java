package task2;

public abstract class Figure {
    private final double radius;
    private double perimetr;

    String figureName;

    Figure(double radius, String figureName) {
        this.radius = radius;
        this.figureName = figureName;
    }

    public double S() {
        return Math.PI * radius * radius;
    }

    public double P() {
        return perimetr = 2 * Math.PI * radius;
    }
}
