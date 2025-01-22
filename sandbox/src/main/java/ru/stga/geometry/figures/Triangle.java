package ru.stga.geometry.figures;


public class Triangle {

    public static void printTriangleArea(double length1, double length2, double length3) {
        String text = String.format("Площадь треугольника со сторонами %f и %f и %f = %f", length1, length2, length3, area(length1, length2, length3));
        System.out.println(text);
    }
    public static double area(double length1, double length2, double length3) {
    // Формула Герона
       return Math.sqrt(((length1 + length2 + length3) / 2.) * (((length1 + length2 + length3) / 2.) - length1) * (((length1 + length2 + length3) / 2.) - length2) * (((length1 + length2 + length3) / 2.) - length3));
}

    public static double semiPerimeter(double length1, double length2, double length3) {
        return (length1 + length2 + length3) / 2.0;
    }
}



