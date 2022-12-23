package task2;

import task1.Rectangle;

public class Parral extends Rectangle implements Volumable {

    private int heigth;

    private void getPloshadBokovoyPoverhnosti(){

    }

    @Override
    public String toString() {
        return "Parral{" +
                "heigth=" + heigth +
                '}';
    }

    @Override
    public int getVolume() {
        return 0;
    }
}
