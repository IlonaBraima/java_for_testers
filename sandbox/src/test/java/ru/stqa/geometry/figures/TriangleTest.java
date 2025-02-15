package ru.stqa.geometry.figures;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stga.geometry.figures.Triangle;

public class TriangleTest {

    @Test
    void testEquality() {
        var t1 = new Triangle(3., 4., 5.);
        var t2 = new Triangle(3., 4., 5.);
        Assertions.assertEquals(t1, t2); // треугольники равны
    }

    @Test
    void testEquality2() {
        var t1 = new Triangle(5., 6., 7.);
        var t2 = new Triangle(6., 7., 5.);
        Assertions.assertEquals(t1, t2); // Порядок сторон отличается, но треугольники равны
    }

    @Test
    void validTriangleSatisfiesInequality() {
        Assertions.assertDoesNotThrow(() -> {
            new Triangle(3.0, 4.0, 5.0); // 3 + 4 > 5, 4 + 5 > 3, 3 + 5 > 4
        });
    }

    @Test
    void cannotCreateTriangleWithNegativeSide() {
        try {
            new Triangle(-3., -4., -5.);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            //OK
        }
    }

    @Test
    void canCalculateArea() {
        var t = new Triangle(3., 4., 5.);
        double result = t.area();
        Assertions.assertEquals(6., result);
    }

    @Test
    void canCalculatePerimeter(){
        Assertions.assertEquals(12., new Triangle(3., 4., 5.).perimeter());
    }
}

