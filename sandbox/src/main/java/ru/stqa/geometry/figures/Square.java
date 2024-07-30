package ru.stqa.geometry.figures;

public class Square {

    double side;

    public Square(double side) {
        this.side = side;
    }

    public static void printArea(Square s){
        System.out.println(String.format("Площадь квадрата со стороной %f = %f", s.side, s.area()));
    }

    public double area() {
        return this.side * this.side;
    }
}
