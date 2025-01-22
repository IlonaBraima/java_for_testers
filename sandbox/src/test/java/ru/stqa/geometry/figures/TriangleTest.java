package ru.stqa.geometry.figures;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stga.geometry.figures.Triangle;

public class TriangleTest {

    @Test
    void canCalculateArea() {
        var t = new Triangle(3., 4., 5.);
        double result = t.area();
        Assertions.assertEquals(6., result);
    }

    @Test
    void canCalculateSemiPerimeter(){
        Assertions.assertEquals(6., new Triangle(3., 4., 5.).semiPerimeter());
    }
}

