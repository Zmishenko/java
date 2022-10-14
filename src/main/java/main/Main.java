package main;

import task1.Circle;
import task1.Rectangle;
import task1.Rhombus;
import task1.Triangle;

import java.util.*;

/**
 * Этот класс нужен для теста задания с фигурами
 */
public class Main {
    public static void main(String[] args) {

        List<Object> objects = new ArrayList<>();
        Circle circle;
        Rectangle rectangle;
        Rhombus rhombus;
        Triangle triangle;

        Scanner scanner = new Scanner(System.in);
        boolean q = true;
        while (q){
            System.out.println("""

                    Выберите фигуру:\s
                    Круг - 1
                    Квардрат/Прямоугольник - 2
                    Ромб - 3
                    Треугольник - 4
                    Завершить - 0
                    """);
            switch (scanner.next()) {
                case ("1") -> {
                    //Круг
                    boolean t = true;
                    while (t) {
                        System.out.print("\nВведите радиус: ");
                        double r = Double.parseDouble(scanner.next());
                        if (r > 0) {
                            t = false;
                            circle = new Circle(r);
                            System.out.println("Круг: " + circle);
                            System.out.println("S: " + circle.S());
                            System.out.println("P: " + circle.P());

                            objects.add(circle);
                        } else {
                            System.out.println("Введите радиус больший 0\n");
                        }
                    }
                }
                case ("2") -> {
                    //Квардрат/Прямоугольник
                    boolean t1 = true;
                    while (t1) {
                        System.out.print("\nВведите длину: ");
                        int w = Integer.parseInt(scanner.next());
                        System.out.print("Введите высоту: ");
                        int h = Integer.parseInt(scanner.next());
                        if (w > 0 && h > 0) {
                            t1 = false;
                            rectangle = new Rectangle(w, h, 0, 0);

                            if (rectangle.isSquare())
                                System.out.println("Квадрат " + rectangle);
                            else
                                System.out.println("Прямоугольник " + rectangle);

                            System.out.println("P: " + rectangle.P());
                            System.out.println("S: " + rectangle.S());
                            System.out.println("Diagonal: " + rectangle.Diagonal());
                            objects.add(rectangle);
                        } else {
                            System.out.println("Введите длину и высоту большe 0\n");
                        }
                    }
                }
                case ("3") -> {
                    //Ромб
                    boolean t3 = true;
                    while (t3) {
                        System.out.print("\nВведите сторону: ");
                        double a = Integer.parseInt(scanner.next());
                        System.out.print("\nВведите высоту: ");
                        double h = Integer.parseInt(scanner.next());

                        if (a > 0 && h > 0 && h >= a) {
                            t3 = false;
                            rhombus = new Rhombus(a, h);

                            System.out.println("Ромб: " + rhombus);
                            System.out.println("P: " + rhombus.P());
                            System.out.println("S: " + rhombus.S());
                            System.out.println("sinA1: " + rhombus.sinAlpha1());
                            System.out.println("sinA2: " + rhombus.sinAlpha2());
                            System.out.println("d1: " + rhombus.Diagonal1());
                            System.out.println("d2: " + rhombus.Diagonal2());
                            System.out.println("r: " + rhombus.radius());
                            objects.add(rhombus);
                        } else {
                            System.out.print("\nОшибка\n");
                        }
                    }
                }
                case ("4") -> {
                    //Треугольник
                    System.out.print("\nВведите минимум 2 значения больше 0\n");
                    boolean t4 = true;
                    while (t4) {
                        System.out.print("\nВведите длину: ");
                        int w = Integer.parseInt(scanner.next());

                        System.out.print("Введите высоту: ");
                        int h = Integer.parseInt(scanner.next());

                        System.out.print("Введите гипотенузу: ");
                        int y = Integer.parseInt(scanner.next());

                        if (new Triangle(w, h, 0, 0).isExsist()) {
                            t4 = false;
                            triangle = new Triangle(w, h, 0, 0);

                            System.out.println("Треугольник " + triangle);
                            System.out.println("P: " + triangle.P());
                            System.out.println("S: " + triangle.S());

                            objects.add(triangle);
                        } else if (new Triangle(w, 0, 0, y).isExsist()) {
                            t4 = false;
                            triangle = new Triangle(w, 0, 0, y);

                            System.out.println("Треугольник " + triangle);
                            System.out.println("P: " + triangle.P());
                            System.out.println("S: " + triangle.S());

                            objects.add(triangle);
                        } else if (new Triangle(0, h, 0, 0).isExsist()) {
                            t4 = false;
                            triangle = new Triangle(0, h, 0, 0);

                            System.out.println("Треугольник " + triangle);
                            System.out.println("P: " + triangle.P());
                            System.out.println("S: " + triangle.S());

                            objects.add(triangle);
                        } else {
                            System.out.println("\nВведите минимум 2 значения больше 0");
                        }
                    }
                }
                case ("0") -> {
                    q = false;
                }
            }
        }

        objects.forEach(System.out::println);
        System.out.println(objects.remove(objects.size()-1));
        System.out.println();
        objects.forEach(System.out::println);
    }
}
