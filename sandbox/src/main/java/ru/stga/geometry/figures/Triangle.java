package ru.stga.geometry.figures;


public record Triangle (double length1, double length2, double length3) {

    public Triangle{
        if (length1 <= 0 || length2 <= 0 || length3 <= 0) {
            throw new IllegalArgumentException("Triangle side should be negative");
        }
        if (length1 + length2 <= length3 || length1 + length3 <= length2 || length2 + length3 <= length1) {
            throw new IllegalArgumentException("Triangle sides violate the triangle inequality");
        }
    }

    public static void printTriangleArea(Triangle t) {
        String text = String.format("Площадь треугольника со сторонами %f и %f и %f = %f", t.length1, t.length2, t.length3, t.area());
        System.out.println(text);
    }

    public double area() {
        return Math.sqrt((this.semiPerimeter()) * ((this.semiPerimeter()) - this.length1) * ((this.semiPerimeter()) - this.length2) * ((this.semiPerimeter()) - this.length3));
    }

    public double semiPerimeter() {return ((this.length1 + this.length2 + this.length3) / 2.);
    }
}



