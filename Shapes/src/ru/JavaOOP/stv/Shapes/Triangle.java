package ru.JavaOOP.stv.Shapes;

public class Triangle implements Shape {
    private double x1;
    private double x2;
    private double x3;
    private double y1;
    private double y2;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;

        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
    }

    private static double getSideLength(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    @Override
    public double getWidth() {
        double max = Math.max(x1, x2);
        double min = Math.min(x1, x2);

        max = Math.max(max, x3);
        min = Math.min(min, x3);

        return max - min;
    }

    @Override
    public double getPerimeter() {
        double a = getSideLength(x1, y1, x2, y2);
        double b = getSideLength(x2, y2, x3, y3);
        double c = getSideLength(x1, y1, x3, y3);
        return (a + b + c);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Triangle triangle = (Triangle) o;

        return (triangle.x1 == x1 && triangle.y1 == y1
                && triangle.x2 == x2 && triangle.y2 == y2 && triangle.x3 == x3 && triangle.y3 == y3);
    }

    @Override
    public int hashCode() {
        final int prime = 17;
        int hash = 1;
        hash = hash * prime + Double.hashCode(x1);
        hash = hash * prime + Double.hashCode(y1);
        hash = hash * prime + Double.hashCode(x2);
        hash = hash * prime + Double.hashCode(y2);
        hash = hash * prime + Double.hashCode(x3);
        hash = hash * prime + Double.hashCode(y3);
        return hash;
    }

    @Override
    public double getHeight() {
        double max = Math.max(y1, y2);
        double min = Math.min(y1, y2);

        max = Math.max(max, y3);
        min = Math.min(min, y3);

        return max - min;
    }

    @Override
    public double getArea() {
        double a = getSideLength(x1, y1, x2, y2);
        double b = getSideLength(x2, y2, x3, y3);
        double c = getSideLength(x1, y1, x3, y3);
        double p = getPerimeter() / 2;

        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public String toString() {
        return "Треугольник с вершинами: A(" + x1 + ", " + y1 + "), B(" + x2 + ", " + y2 + "), C(" + x3 + ", " + y3 + ")";
    }
}
