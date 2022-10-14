package task1;
//https://www.calculat.org/ru/%D0%BF%D0%BB%D0%BE%D1%89%D0%B0%D0%B4%D1%8C-%D0%BF%D0%B5%D1%80%D0%B8%D0%BC%D0%B5%D1%82%D1%80/%D1%82%D1%80%D0%B5%D1%83%D0%B3%D0%BE%D0%BB%D1%8C%D0%BD%D0%B8%D0%BA/
//https://www.calculat.org/ru/%D0%BF%D0%BB%D0%BE%D1%89%D0%B0%D0%B4%D1%8C-%D0%BF%D0%B5%D1%80%D0%B8%D0%BC%D0%B5%D1%82%D1%80/%D0%BF%D1%80%D1%8F%D0%BC%D0%BE%D1%83%D0%B3%D0%BE%D0%BB%D1%8C%D0%BD%D1%8B%D0%B9-%D1%82%D1%80%D0%B5%D1%83%D0%B3%D0%BE%D0%BB%D1%8C%D0%BD%D0%B8%D0%BA/
import main.Shape;

public class Triangle implements Shape {
    private double v, h, x, y;

    public Triangle() {
    }

    public Triangle(int v, int h, int x, int y) {
        this.v = v;
        this.h = h;
        this.x = x;
        this.y = y;
    }

    public double getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public double getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "v=" + v +
                ", h=" + h +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    public double P(){
        if (y == 0){
            y = Math.sqrt((getH() * getH()) + (getV() * getV()));
            return getH() + getV() + getY();
        }else if (h == 0){
            h = Math.sqrt((getY() * getY()) - (getV() * getV()));
            return getH() + getV() + getY();
        }else if (v == 0){
            v = Math.sqrt((getY() * getY()) - (getH() * getH()));
            return getH() + getV() + getY();
        }else {
            return getH() + getV() + getY();
        }
    }

    public double S(){
        return (getH() * getV()) / 2.0;
    }

    public boolean isExsist(){
        if (v + h > x) return false;
        if (v + x > h) return false;
        if (h + x > v) return false;
        return true;
    }

    @Override
    public void draw() {

    }
}
