package ru.JavaOOP.stv.Vector.Main;

import ru.JavaOOP.stv.Vector.Vector;

public class Main {
    public static void main(String[] args) {
        Vector vec = new Vector(5);
        Vector vec2 = new Vector(vec);
        double[] vec33 = {1.0, 3.5, 7.8, 4.1};
        double[] vec34 = {5, 9.9, 7.4, 0, -1, -8.9};

        Vector vec3 = new Vector(vec33);
        Vector vec5 = new Vector(vec34);

        String str = vec3.toString();

        boolean test1 = str.equals("{1.0, 3.5, 7.8, 4.1 }");

        vec.add(vec3);
        vec3.subtract(vec3);

        boolean test2 = vec.equals(new Vector(new double[]{1.0, 3.5, 7.8, 4.1, 0}));
        boolean test3 = vec3.equals(new Vector(new double[]{0, 0, 0, 0}));

        vec3.setElementAt(2, -8);

        boolean test5 = vec3.equals(new Vector(new double[]{0, 0, -8, 0}));

        vec5.setElementAt(3, vec3.getElementAt(1));

        boolean test6 = vec5.equals(new Vector(new double[]{5, 9.9, 7.4, 0.0, -1, -8.9}));
        double length = vec5.getLength();
        boolean test4 = Math.abs(length - 16.061756) <= 1e-5;

        Vector statVec1 = Vector.addition(vec, vec3);
        vec.invert();
        Vector statVec2 = Vector.subtraction(vec, statVec1);
        double statVecSum = Vector.multiplication(statVec2, statVec1);

        boolean test7 = statVec1.equals(new Vector(new double[]{1.0, 3.5, -0.20000000000000018, 4.1, 0}));
        boolean test8 = statVec2.equals(new Vector(new double[]{-2, -7, -7.6, -8.2, -0.0}));
        boolean test9 = Math.abs(statVecSum + 58.6) <= 1e-5;

        int hash1 = vec.hashCode();
        int hash2 = vec2.hashCode();
        int hash3 = vec3.hashCode();
        Vector testVec = new Vector(new double[]{0, 0, 0, 0, 0});
        int hash4 = testVec.hashCode();

        boolean e1 = vec.equals(vec2);
        boolean e2 = vec3.equals(vec);
        boolean e3 = vec2.equals(testVec);

        if (test1 && test2 && test3 && test5 && test6
                && test7 && test8 && test9) {
            System.out.println("Все тесты прошли успешно!");
        } else {
            System.out.println("Где-то есть ошибка");
        }

    }
}
