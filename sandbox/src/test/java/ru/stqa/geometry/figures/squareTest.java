package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stga.geometry.figures.Square;

public class squareTest {

    @Test
    void canCalculateArea(){
        double result = Square.area(5.0);
        Assertions.assertEquals(25.0, result);
    }

    @Test
    void canCalculatePerimeter(){
        Assertions.assertEquals(20.0, Square.perimeter(5.0));
    }

}
