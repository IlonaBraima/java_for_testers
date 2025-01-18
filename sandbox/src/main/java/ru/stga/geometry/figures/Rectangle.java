package ru.stga.geometry.figures;

public class Rectangle {
    public static void printRectangleArea(double a, double b) {
        System.out.println("Площадь прямоугольника со сторонами " + a + " и " + b +" = " + regtangleArea(a, b));
    }

    private static double regtangleArea(double a, double b) {
        return a * b;
    }
}
