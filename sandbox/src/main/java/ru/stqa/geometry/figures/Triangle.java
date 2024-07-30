package ru.stqa.geometry.figures;

public class Triangle {

    public static void printTriangle(double a, double b, double c) {
        String textPerimeter = String.format("Периметр треугольника со сторонами %f, %f и %f = %f", a, b, c, trianglePerimeter(a, b, c));
        String textArea = String.format("Площадь треугольника со сторонами %f, %f и %f = %f", a, b, c, triangleArea(a, b, c));
        System.out.println(textArea);
        System.out.println(textPerimeter);
    }

    private static double trianglePerimeter(double a, double b, double c){
        return a + b + c;
    }

    private static double triangleArea(double a, double b, double c){
       double p = trianglePerimeter(a ,b ,c) / 2;
       double S = Math.sqrt(p * (p - a) * (p - b) * (p - c));
       return S;
    }
}
