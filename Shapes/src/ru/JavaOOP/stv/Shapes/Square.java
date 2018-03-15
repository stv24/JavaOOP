package ru.JavaOOP.stv.Shapes;

public class Square implements Shape {
    private double length;

    public Square(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return length * length;
    }

    @Override
    public double getHeight() {
        return length;
    }

    @Override
    public double getPerimeter() {
        return 4 * length;
    }

    @Override
    public double getWidth() {
        return length;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Square square = (Square) o;

        return square.length == length;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(length);
    }

    @Override
    public String toString() {
        return "Квадрат со стороной " + length;
    }
}
