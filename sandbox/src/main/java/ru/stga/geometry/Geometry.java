package ru.stga.geometry;

import ru.stga.geometry.figures.Rectangle;
import ru.stga.geometry.figures.Square;
import ru.stga.geometry.figures.Triangle;

import java.util.List;
import java.util.function.Consumer;

public class Geometry {

    public static void main(String[] args) {
        var squares = List.of(new Square(7.), new Square(5.), new Square(3.));
//        for (Square square : squares) {
//            Square.printSquareArea(square);
//        }
                squares.forEach(Square::printSquareArea);


        //public static void main(String[] args) {
//            var rectangles = List.of(new Rectangle(3., 5), new Rectangle(5., 9));
//            Consumer<Rectangle> print = (rectangle) -> {
//                Rectangle.printRectangleArea(rectangle);
//            };
//        rectangles.forEach(print);
//        Rectangle.printRectangleArea(3., 5.);
//        Rectangle.printRectangleArea(7., 9.);

//        Triangle.printTriangleArea(new Triangle(3., 4., 5.));
//        Triangle.printTriangleArea(new Triangle(5., 6., 7.));

    }

}
