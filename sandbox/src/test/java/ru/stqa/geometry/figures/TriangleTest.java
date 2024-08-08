package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {
    @Test
    void canCalculatePerimeter(){
        var s = new Triangle(3.0, 4.0, 5.0);
        var result = s.perimeter();
        assertEquals(12.0, result);
    }
    @Test
    void canCalculateArea(){
        var s = new Triangle(3.0, 4.0, 5.0);
        var result = s.area();
        assertEquals(6, result);
    }

    @Test
    void cannotCreateTriangleNegativeSide(){
        try {
            new Triangle(-1, 3, 2);
            fail();
        }catch (IllegalArgumentException exception){
           // System.out.println("Ok");
        }
    }

    @Test
    void triangleInequality(){
        try {
            new Triangle(6, 2, 3);
            fail();
        }catch (IllegalArgumentException exception){
             System.out.println("Ok");
        }
    }

    @Test
    void comparisonsTriangle(){
        var t1 = new Triangle(3, 4, 5);
        var t2 = new Triangle(4, 5, 3);
        Assertions.assertTrue(t1.equals(t2));

    }

    @Test
    void testEquality(){
        var a = 2;
        var b = 3;
        var c = 4;
        var triangle = new Triangle(a, b, c);
        var triangle1 = new  Triangle(c, a, b);
        Assertions.assertEquals(triangle, triangle1);
    }

}
