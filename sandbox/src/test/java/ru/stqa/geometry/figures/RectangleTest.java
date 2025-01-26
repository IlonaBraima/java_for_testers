package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stga.geometry.figures.Rectangle;

import java.awt.*;

import static ru.stga.geometry.figures.Rectangle.printRectangleArea;

public class RectangleTest {

    @Test
    void cannotCreateRectangleWithNegativeSide() {
        try {
            new Rectangle (-5.0, 3.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            //OK
        }
    }
}
