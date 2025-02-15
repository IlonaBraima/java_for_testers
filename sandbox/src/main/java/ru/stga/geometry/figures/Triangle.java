package ru.stga.geometry.figures;

public record Triangle(double length1, double length2, double length3) {

    public Triangle {
        if (length1 <= 0 || length2 <= 0 || length3 <= 0) {
            throw new IllegalArgumentException("Triangle side should be negative");
        }
        if (length1 + length2 <= length3 || length1 + length3 <= length2 || length2 + length3 <= length1) {
            throw new IllegalArgumentException("Triangle sides violate the triangle inequality");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
//        способ ||, как у прямоугольника не сработал
//        return (Double.compare(this.length1, triangle.length1) == 0 && Double.compare(this.length2, triangle.length2) == 0 && Double.compare(this.length3, triangle.length3) == 0)
//                || (Double.compare(this.length2, triangle.length1) == 0 && Double.compare(this.length3, triangle.length1) == 0 && Double.compare(this.length1, triangle.length3) == 0)
//                || (Double.compare(this.length3, triangle.length1) == 0 && Double.compare(this.length1, triangle.length2) == 0 && Double.compare(this.length2, triangle.length3) == 0);


//        внедряю способ сравнения массивов
        double[] thisSides = {length1, length2, length3};
        double[] otherSides = {triangle.length1, triangle.length2, triangle.length3};

//      java.util.Arrays.equals – стандартный метод для сравнения массивов
        java.util.Arrays.sort(thisSides);
        java.util.Arrays.sort(otherSides);

        return java.util.Arrays.equals(thisSides, otherSides);
    }

    @Override
    public int hashCode() {
        double[] sides = {length1, length2, length3};
        java.util.Arrays.sort(sides);
        return java.util.Objects.hash(sides[0], sides[1], sides[2]);
    }

    public static void printTriangleArea(Triangle t) {
        String text = String.format("Площадь треугольника со сторонами %f и %f и %f = %f", t.length1, t.length2, t.length3, t.area());
        System.out.println(text);
    }

    public double perimeter(

    ) {
        return this.length1 + this.length2 + this.length3;
    }

    public double area() {
        double semiPerimeter = perimeter() / 2;
        return Math.sqrt
                (semiPerimeter
                        * (semiPerimeter - length1)
                        * (semiPerimeter - length2)
                        * (semiPerimeter - length3));
    }
}



