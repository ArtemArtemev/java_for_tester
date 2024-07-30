package ru.stqa.geometry;

import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Square;
import ru.stqa.geometry.figures.Triangle;

public class Geometry {
    public static void main(String[] args) {
        Square.printArea(5.0);

        Rectangle.printArea(4.0, 6.0);

        Triangle.printTriangle(26, 28, 30);
    }

}
