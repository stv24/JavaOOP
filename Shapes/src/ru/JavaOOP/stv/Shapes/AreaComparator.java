package ru.JavaOOP.stv.Shapes;

import java.util.Comparator;

public class AreaComparator implements Comparator<Shape> {
    public int compare(Shape shape1, Shape shape2) {
        return (int) (shape1.getArea() - shape2.getArea());

    }
}
