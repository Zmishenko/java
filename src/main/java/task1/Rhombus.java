package task1;

import main.Shape;

//https://www.calculat.org/ru/%D0%BF%D0%BB%D0%BE%D1%89%D0%B0%D0%B4%D1%8C-%D0%BF%D0%B5%D1%80%D0%B8%D0%BC%D0%B5%D1%82%D1%80/%D1%80%D0%BE%D0%BC%D0%B1/
public class Rhombus extends Shape {
    //a - сторона h - высота, alpha - угол
    private double a, h;
    private double alpha1;
    private double alpha2;

    private double perimetr = 0;

    public Rhombus() {
    }

    public Rhombus(double a, double h) {
        this.a = a;
        this.h = h;
    }

    @Override
    public String toString() {
        return "Rhombus{" +
                "Сторона = " + a +
                ", Высота = " + h +
                '}';
    }

    public double P(){
        return perimetr = 4 * a;
    }

    public double S(){
        return a * h;
    }

    public double sinAlpha1(){
        return alpha1 = h/a;
    }

    public double sinAlpha2(){
        return alpha2 = 180 - alpha1;
    }
    public  double Diagonal1(){
        double d2;
        return d2 = a * Math.sqrt(2 - 2 * Math.cos(alpha2));
    }

    public  double Diagonal2(){
        double d1;
        return d1 = a * Math.sqrt(2 - 2 * Math.cos(alpha1));
    }

    public double radius(){
        double r;
        return r = h/2;
    }

}
