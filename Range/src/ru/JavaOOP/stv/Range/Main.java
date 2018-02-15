package ru.JavaOOP.stv.Range;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Range2 range1 = new Range2(3, 4);
        Range2 range2 = new Range2(1, 2);
        Range2 range_result = range1.getIntersection(range2);
        Range2[] range_r2 = range1.getDifference(range2);
        Range2[] r3 = range2.getUnion(range1);
    }
}
