package ru.stqa.geometry.figures;

public class Square {
    public static void printArea(double side){
        System.out.println(String.format("Площадь квадрата со стороной %f = %f", side, Area(side)));
    }

    public static double Area(double a) {
        return a * a;
    }
}
