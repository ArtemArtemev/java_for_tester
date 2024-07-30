package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectangleTest {
    @Test
    void canCalculateArea(){
        var s = new Rectangle(4, 6);
        var result = s.area();
        Assertions.assertEquals(24, result);
    }
}
