package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {
    @Test
    void canCalculatePerimeter(){
        var s = new Triangle(3.0, 4.0, 5.0);
        var result = s.perimeter();
        Assertions.assertEquals(12.0, result);
    }
    @Test
    void canCalculateArea(){
        var s = new Triangle(3.0, 4.0, 5.0);
        var result = s.area();
        Assertions.assertEquals(6, result);
    }

    @Test
    void cannotCreateTriangleNegativeSide(){
        try {
            new Triangle(-1, 3, 2);
            Assertions.fail();
        }catch (IllegalArgumentException exception){
           // System.out.println("Ok");
        }
    }

    @Test
    void triangleInequality(){
        try {
            new Triangle(6, 2, 3);
            Assertions.fail();
        }catch (IllegalArgumentException exception){
             System.out.println("Ok");
        }
    }

}
