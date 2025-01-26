package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Test;

public class mathTests {
    @Test
    void testDivideByZero() {
        var x = 1;
        var y = 0;
        var z = x / y;
        System.out.println(z);
    }
}
