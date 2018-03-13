package ru.JavaOOP.stv.Shapes.Main;

import ru.JavaOOP.stv.Shapes.*;

import java.util.Arrays;


public class Main {


    public static Shape getMaxAreaShape(Shape[] shapes) {
        Arrays.sort(shapes, Shape.areaComparator);
        return shapes[shapes.length - 1];
    }

    public static Shape getSecondPerimeterShape(Shape[] shapes) {
        Arrays.sort(shapes, Shape.perimeterComparator);
        return shapes[shapes.length - 2];

    }

    public static void main(String[] args) {
        Shape[] shapes = {new Circle(5), new Square(4), new Rectangle(5, 9),
                new Triangle(1, 3, 2, -5, -8, 4), new Triangle(5, 3, 3, 5, -2, 2)};

        Shape maxAreaShape = getMaxAreaShape(shapes);
        Shape secondPerimeterShape = getSecondPerimeterShape(shapes);

        System.out.println("Фигура с максимальной площадью " + maxAreaShape.toString());

        System.out.println("Фигура со вторым по величине периметром " + secondPerimeterShape.toString());


    }
}
