package shape;

public class Triangle {
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
}
