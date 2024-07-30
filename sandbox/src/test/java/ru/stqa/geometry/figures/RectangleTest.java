package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectangleTest {
    @Test
    void canCalculateArea(){
        var result = Rectangle.Area(4, 6);
        Assertions.assertEquals(24, result);
    }
}
