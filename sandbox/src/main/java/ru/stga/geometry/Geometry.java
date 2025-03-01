package ru.stga.geometry;

import ru.stga.geometry.figures.Rectangle;
import ru.stga.geometry.figures.Square;
import ru.stga.geometry.figures.Triangle;

import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Geometry {

    public static void main(String[] args) {
        Supplier<Square> randomSquare = () -> new Square(new Random().nextDouble (100.));
        var squares = Stream.generate(randomSquare).limit(5);

                squares.peek(Square::printSquareArea).forEach(Square::printSquarePerimeter);

    }
}

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


