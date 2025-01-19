package ru.stga.geometry.figures;

public class Rectangle {
    public static void printRectangleArea(double a, double b) {
        var text = String.format("Площадь прямоугольника со сторонами %f и %f = %f", a, b, regtangleArea(a, b));
    }

    private static double regtangleArea(double a, double b) {
        return a * b;
    }
}
