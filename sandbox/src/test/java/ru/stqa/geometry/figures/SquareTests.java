package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquareTests {
    @Test
    void canCalculateArea(){
        var s = new Square(5.0);
        double result = s.area();
        Assertions.assertEquals(25.0, result);
    }

    @Test
    void testFail(){
        var s1 = new Square(5);
        var s2 = new Square(5);
        Assertions.assertTrue(s1.equals(s2));
    }
}
