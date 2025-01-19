package ru.stga.geometry;

import ru.stga.geometry.figures.Rectangle;
import ru.stga.geometry.figures.Square;
import ru.stga.geometry.figures.Triangle;

public class Geometry {
    public static void main(String[] args) {

        Square.printSquareArea(new Square(7.));
        Square.printSquareArea(new Square(5.));
        Square.printSquareArea(new Square (3.));

        Rectangle.printRectangleArea(3., 5.);
        Rectangle.printRectangleArea(7., 9.);

        Triangle.printTriangleArea(3., 4., 5.);
        Triangle.printTriangleArea(5., 6., 7.);

}

}
