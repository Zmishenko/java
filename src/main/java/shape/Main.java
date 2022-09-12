package shape;

import java.util.Scanner;

/**
 * Этот класс нужен для теста задания с фигурами
 */
public class Main {
    public static void main(String[] args) {
        Circle circle;
        Rectangle rectangle;
        Rhombus rhombus;
        Triangle triangle;

        Scanner scanner = new Scanner(System.in);
        boolean q = true;
        while (q){
            System.out.println("\nВыберите фигуру: \nКруг - 1\nКвардрат/Прямоугольник - 2\nРомб - 3\nТреугольник - 4\nЗавершить - 0\n");
            switch (scanner.next()){
                case ("1"):
                    //Круг
                    boolean t = true;
                    while (t){
                        System.out.print("\nВведите радиус: ");
                        double r = Double.parseDouble(scanner.next());
                        if (r > 0){
                            t = false;
                            circle = new Circle(r);
                            System.out.println("Круг: " + circle.toString());
                            System.out.println("S: " + circle.S());
                            System.out.println("P: " + circle.P());
                        }else {
                            System.out.println("Введите радиус больший 0\n");
                        }
                    }
                    break;
                case ("2"):
                    //Квардрат/Прямоугольник
                    boolean t1 = true;
                    while (t1){
                        System.out.print("\nВведите длину: ");
                        int w = Integer.parseInt(scanner.next());
                        System.out.print("Введите высоту: ");
                        int h = Integer.parseInt(scanner.next());
                        if (w > 0 && h > 0){
                            t1 = false;
                            rectangle = new Rectangle(w, h, 0, 0);

                            if (rectangle.isSquare())
                                System.out.println("Квадрат " + rectangle.toString());
                            else
                                System.out.println("Прямоугольник " + rectangle.toString());

                            System.out.println("P: " + rectangle.P());
                            System.out.println("S: " + rectangle.S());
                            System.out.println("Diagonal: " + rectangle.Diagonal());
                        }else {
                            System.out.println("Введите длину и высоту большe 0\n");
                        }
                    }
                    break;
                case ("3"):
                    //Ромб
                    boolean t3 = true;
                    while (t3){
                        System.out.print("\nВведите длину: ");
                        int w = Integer.parseInt(scanner.next());

                        System.out.print("Введите высоту: ");
                        int h = Integer.parseInt(scanner.next());

                        if (w > 0 && h > 0){
                            t3 = false;
                            rhombus = new Rhombus(w, h, 0, 0);

                            System.out.println("Ромб: " + rhombus.toString());
                            System.out.println("P: " + rhombus.P());
                            System.out.println("S: " + rhombus.S());
                            System.out.println("Diagonal1: " + rhombus.Diagonal1());
                            System.out.println("Diagonal2: " + rhombus.Diagonal2());
                        }else {
                            System.out.print("\nВведите длину и высотубольше 0\n");
                        }
                    }
                    break;
                case ("4"):
                    //Треугольник
                    System.out.print("\nВведите минимум 2 значения больше 0\n");
                    boolean t4 = true;
                    while (t4){
                        System.out.print("\nВведите длину: ");
                        int w = Integer.parseInt(scanner.next());

                        System.out.print("Введите высоту: ");
                        int h = Integer.parseInt(scanner.next());

                        System.out.print("Введите гипотенузу: ");
                        int y = Integer.parseInt(scanner.next());

                        if (w > 0 && h > 0){
                            t4 = false;
                            triangle = new Triangle(w, h, 0, 0);

                            System.out.println("Треугольник " + triangle.toString());
                            System.out.println("P: " + triangle.P());
                            System.out.println("S: " + triangle.S());
                        }else if(w > 0 && y > 0){
                            t4 = false;
                            triangle = new Triangle(w, 0, 0, y);

                            System.out.println("Треугольник " + triangle.toString());
                            System.out.println("P: " + triangle.P());
                            System.out.println("S: " + triangle.S());
                        }else if(h > 0 && y > 0){
                            t4 = false;
                            triangle = new Triangle(0, h, 0, 0);

                            System.out.println("Треугольник " + triangle.toString());
                            System.out.println("P: " + triangle.P());
                            System.out.println("S: " + triangle.S());
                        }else {
                            System.out.println("\nВведите минимум 2 значения больше 0");
                        }
                    }
                    break;
                case ("0"):
                    q = false;
                    return;
            }
        }


        System.out.println();
    }
}
