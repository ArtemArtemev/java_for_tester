package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {
    @Test
    void canCalculatePerimeter(){
        var result = Triangle.perimeter(3, 4, 5);
        Assertions.assertEquals(12, result);
    }
    @Test
    void canCalculateArea(){
        var result = Triangle.area(3, 4, 5);
        Assertions.assertEquals(6, result);
    }
}
