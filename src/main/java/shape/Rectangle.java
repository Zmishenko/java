package shape;

public class Rectangle {
    private int v, h, x, y;

    public Rectangle() {
    }

    public Rectangle(int v, int h, int x, int y) {
        this.v = v;
        this.h = h;
        this.x = x;
        this.y = y;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "v=" + v +
                ", h=" + h +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    public double P(){
        return getH() + getH() + getV() + getV();
    }

    public double S(){
        return getH()*getV();
    }

    public  double Diagonal(){
        return Math.sqrt(getH()^2 + getH()^2);
    }

    public boolean isSquare(){
        return getH() == getV();
    }
}
