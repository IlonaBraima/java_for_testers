package ru.stga.geometry.figures;


public class Triangle {

    public double length1;
    public double length2;
    public double length3;

    public Triangle(double length1, double length2, double length3) {
        this.length1 = length1;
        this.length2 = length2;
        this.length3 = length3;
    }

    public static void printTriangleArea(Triangle t) {
        String text = String.format("Площадь треугольника со сторонами %f и %f и %f = %f", t.length1, t.length2, t.length3, t.area());
        System.out.println(text);
    }

    public double area() {
        return Math.sqrt(((this.length1 + this.length2 + this.length3) / 2.) * (((this.length1 + this.length2 + this.length3) / 2.) - this.length1) * (((this.length1 + this.length2 + this.length3) / 2.) - this.length2) * (((this.length1 + this.length2 + this.length3) / 2.) - this.length3));
    }

    public double semiPerimeter() {
        return ((this.length1 + this.length2 + this.length3) / 2.);
    }
}



