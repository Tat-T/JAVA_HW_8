package org.example;

import org.example.geometry.model.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите фигуру для расчета площади:");
        System.out.println("1. Треугольник\n2. Прямоугольник\n3. Квадрат\n4. Ромб");
        int choice = scanner.nextInt();

        Shape shape = null;
        switch (choice) {
            case 1:
                System.out.print("Введите основание треугольника: ");
                double base = scanner.nextDouble();
                System.out.print("Введите высоту треугольника: ");
                double height = scanner.nextDouble();
                shape = new Triangle(base, height);
                break;
            case 2:
                System.out.print("Введите ширину прямоугольника: ");
                double width = scanner.nextDouble();
                System.out.print("Введите высоту прямоугольника: ");
                height = scanner.nextDouble();
                shape = new Rectangle(width, height);
                break;
            case 3:
                System.out.print("Введите сторону квадрата: ");
                double side = scanner.nextDouble();
                shape = new Square(side);
                break;
            case 4:
                System.out.print("Введите первую диагональ ромба: ");
                double d1 = scanner.nextDouble();
                System.out.print("Введите вторую диагональ ромба: ");
                double d2 = scanner.nextDouble();
                shape = new Rhombus(d1, d2);
                break;
            default:
                System.out.println("Некорректный выбор!");
                System.exit(0);
        }

        System.out.printf("Площадь фигуры: %.2f\n", shape.calculateArea());
    }
}
