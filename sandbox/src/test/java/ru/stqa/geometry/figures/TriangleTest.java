package ru.stqa.geometry.figures;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stga.geometry.figures.Triangle;

public class TriangleTest {

    @Test
    void canCalculateArea() {
        Assertions.assertEquals(6., Triangle.area(3., 4., 5.));
    }

    @Test
    void canCalculateSemiPerimeter(){
        Assertions.assertEquals(6., Triangle.semiPerimeter(3., 4., 5.));
    }
}

