package ru.JavaOOP.stv.Shapes;

import java.util.Comparator;

public class PerimeterComparator implements Comparator<Shape> {
    public int compare(Shape shape1, Shape shape2) {
        return (int) (shape1.getPerimeter() - shape2.getPerimeter());
    }
}
