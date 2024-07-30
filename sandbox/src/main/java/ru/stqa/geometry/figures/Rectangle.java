package ru.stqa.geometry.figures;

public class Rectangle {

    double a;
    double b;

    public Rectangle(double a, double b){
        this.a = a;
        this.b = b;
    }
    public static void printArea(Rectangle s) {
        String text = String.format("Площадь прямоугольника со сторонами %f и %f = %f", s.a, s.b, s.area());
        System.out.println(text);
    }


    public double area() {
        return this.a * this.b;
    }
}
