package ru.stqa.geometry.figures;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stga.geometry.figures.Triangle;

public class TriangleTest {

    @Test
    void canCalculateAreaTest() {
        Assertions.assertEquals(6.0, Triangle.triangleArea(3.0, 4.0, 5.0));

    }

    @Test
    void canCalculateSemiPerimeter() {
        Assertions.assertEquals(6.0, Triangle.perimeter(3.0, 4.0, 5.0));
    }
}

