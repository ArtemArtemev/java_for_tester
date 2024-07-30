package ru.stqa.geometry;

import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Square;
import ru.stqa.geometry.figures.Triangle;

public class Geometry {
    public static void main(String[] args) {
        Square.printArea(new Square(5.0));

        Rectangle.printArea(new Rectangle(4, 6));

        Triangle.printTriangle(new Triangle( 26.0, 28.0, 30.0));
    }

}
