package ru.JavaOOP.stv.Shapes;

import java.util.Comparator;

public interface Shape {
    double getWidth();

    double getHeight();

    double getArea();

    double getPerimeter();

    Comparator<Shape> areaComparator =
            (Shape shape1, Shape shape2) -> (int) (shape1.getArea() - shape2.getArea());

    Comparator<Shape> perimeterComparator =
            (Shape shape1, Shape shape2) -> (int) (shape1.getPerimeter() - shape2.getPerimeter());

}
