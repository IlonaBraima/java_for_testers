package ru.stga.geometry.figures;

public record Triangle(
        double length1,
        double length2,
        double length3) {

    public static void printTriangleArea(
            double length1,
            double length2,
            double length3
    ) {
        var text = String.format("Площадь треугольника со сторонами %f, %f и %f = %f",
                length1, length2, length3, triangleArea(length1, length2, length3));
        System.out.println(text);
    }

    private static double triangleArea(double length1, double length2, double length3) {
        // Полупериметр
        double sPerimeter = (length1 + length2 + length3) / 2;
        // Площадь по формуле Герона
        return Math.sqrt(sPerimeter *
                (sPerimeter - length1) *
                (sPerimeter - length2) *
                (sPerimeter - length3));
    }
}