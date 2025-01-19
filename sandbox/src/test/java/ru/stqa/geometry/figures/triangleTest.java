package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stga.geometry.figures.Square;
import ru.stga.geometry.figures.Triangle;

public class triangleTest{

    @Test
    void canCalculateArea() {
        var t = new Triangle(3., 4., 5.);;
        double result = t.area();
        Assertions.assertEquals(25.0, result);
    }

    @Test
    void canCalculateArea(){
        Assertions.assertEquals(20.0, new Square(5.0).perimeter());
    }

}