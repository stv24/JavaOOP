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
        Vector vec4 = new Vector(10, vec33);
        String str = vec3.toString();

        boolean test1 = str.equals("{1.0, 3.5, 7.8, 4.1 }");

        Vector sum = vec.add(vec3);
        Vector diff = vec3.subtract(vec3);
        Vector iSum = sum.invert();

        boolean test2 = sum.equals(new Vector(new double[]{1.0, 3.5, 7.8, 4.1, 0}));
        boolean test3 = diff.equals(new Vector(new double[]{0, 0, 0, 0}));
        boolean test4 = iSum.equals(new Vector(new double[]{-1.0, -3.5, -7.8, -4.1, -0.0}));

        vec3.setElementAt(2, -8);

        boolean test5 = vec3.equals(new Vector(new double[]{1.0, 3.5, -8, 4.1}));

        vec5.setElementAt(3, vec3.getElementAt(1));

        boolean test6 = vec5.equals(new Vector(new double[]{5, 9.9, 7.4, 3.5, -1, -8.9}));

        Vector statVec1 = Vector.addition(sum, diff);
        Vector statVec2 = Vector.subtraction(iSum, statVec1);
        double statVecSum = Vector.multiplication(statVec2, statVec1);

        boolean test7 = statVec1.equals(new Vector(new double[]{1.0, 3.5, 7.8, 4.1, 0}));
        boolean test8 = statVec2.equals(new Vector(new double[]{-2, -7, -15.6, -8.2, -0.0}));
        boolean test9 = statVecSum == -181.8;

        int hash1 = vec.hashCode();
        int hash2 = vec2.hashCode();
        int hash3 = vec3.hashCode();
        int hash4 = sum.hashCode();

        boolean e1 = vec.equals(vec2);
        boolean e2 = vec3.equals(sum);

        if (test1 && test2 && test3 && test4 && test5 && test6
                && test7 && test8 && test9) {
            System.out.println("Все тесты прошли успешно!");
        } else {
            System.out.println("Где-то есть ошибка");
        }

    }
}
