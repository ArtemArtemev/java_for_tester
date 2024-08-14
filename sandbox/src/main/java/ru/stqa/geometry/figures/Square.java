package ru.stqa.geometry.figures;


import java.util.Objects;

public record Square(double side) {

    public static void printArea(Square s) {
        System.out.println(String.format("Площадь квадрата со стороной %f = %f", s.side, s.area()));
    }

    public double area() {
        return this.side * this.side;
    }

    public double side() {
        return side;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Square) obj;
        return Double.doubleToLongBits(this.side) == Double.doubleToLongBits(that.side);
    }

    @Override
    public int hashCode() {
        return Objects.hash(side);
    }

}
