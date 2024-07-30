package ru.stqa.geometry.figures;

public class Triangle {

    double a;
    double b;
    double c;

    public Triangle(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static void printTriangle(Triangle s) {
        String textPerimeter = String.format("Периметр треугольника со сторонами %f, %f и %f = %f", s.a, s.b, s.c, s.perimeter());
        String textArea = String.format("Площадь треугольника со сторонами %f, %f и %f = %f", s.a, s.b, s.c, s.area());
        System.out.println(textArea);
        System.out.println(textPerimeter);
    }

    public static double perimeter(double a, double b, double c){
        return a + b + c;
    }

    public static double area(double a, double b, double c){
       double p = perimeter(a ,b ,c) / 2;
       double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
       return s;
    }

    public double perimeter() {
        return this.a + this.b + this.c;
    }

    public double area(){
        double p = perimeter()/ 2;
        double s = Math.sqrt(p * (p - this.a) * (p - this.b) * (p - this.c));
        return s;
    }
}
