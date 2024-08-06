package ru.stqa.geometry.figures;

public class Triangle {

    double a;
    double b;
    double c;

    public Triangle(double a, double b, double c){

        this.a = a;
        this.b = b;
        this.c = c;

        if(a <= 0 || b <= 0 || c <= 0){
            throw new IllegalArgumentException("The side cannot be negative");
        }

        if(a + b < c || a + c < b || b + c < a){
            throw new IllegalArgumentException("The sum of the two sides cannot be less than the third");
        }
    }


    public static void printTriangle(Triangle s) {
        String textPerimeter = String.format("Периметр треугольника со сторонами %f, %f и %f = %f", s.a, s.b, s.c, s.perimeter());
        String textArea = String.format("Площадь треугольника со сторонами %f, %f и %f = %f", s.a, s.b, s.c, s.area());
        System.out.println(textArea);
        System.out.println(textPerimeter);
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
