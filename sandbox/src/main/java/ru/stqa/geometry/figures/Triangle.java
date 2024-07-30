package ru.stqa.geometry.figures;

public class Triangle {

    public static void printTriangle(double a, double b, double c) {
        String textPerimeter = String.format("Периметр треугольника со сторонами %f, %f и %f = %f", a, b, c, perimeter(a, b, c));
        String textArea = String.format("Площадь треугольника со сторонами %f, %f и %f = %f", a, b, c, area(a, b, c));
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
}
