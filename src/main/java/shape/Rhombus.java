package shape;

public class Rhombus {

    private int v, h, x, y;

    public Rhombus() {
    }

    public Rhombus(int v, int h, int x, int y) {
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
        return "Rhombus{" +
                "v=" + v +
                ", h=" + h +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    public double P(){
        return 4 * getV();
    }

    public double S(){
        return (getH() * getV()) / 2.0;
    }

    public  double Diagonal1(){
        return Math.sqrt(getH()^2 + getH()^2);
    }

    public  double Diagonal2(){
        return Math.sqrt(getX()^2 + getY()^2);
    }


}
