package ru.JavaOOP.stv.Range.Main;

import ru.JavaOOP.stv.Range.Range;

public class Main {
    public static void main(String[] args) {
        Range range1 = new Range(5, 10);
        Range range20 = new Range(5, 10);
        Range range21 = new Range(6, 8);
        Range range22 = new Range(4, 11);
        Range range23 = new Range(4, 5);
        Range range24 = new Range(10, 15);
        Range range25 = new Range(11, 15);
        Range range26 = new Range(0, 3);
        Range range27 = new Range(7, 10);
        Range range28 = new Range(5, 8);
        Range range29 = new Range(5, 15);
        Range range210 = new Range(1, 10);

        Range res00 = range1.getIntersection(range20);
        Range[] res01 = range1.getUnion(range20);
        Range[] res02 = range1.getDifference(range20);

        Range res10 = range1.getIntersection(range21);
        Range[] res11 = range1.getUnion(range21);
        Range[] res12 = range1.getDifference(range21);

        Range res20 = range1.getIntersection(range22);
        Range[] res21 = range1.getUnion(range22);
        Range[] res22 = range1.getDifference(range22);

        Range res30 = range1.getIntersection(range23);
        Range[] res31 = range1.getUnion(range23);
        Range[] res32 = range1.getDifference(range23);

        Range res40 = range1.getIntersection(range24);
        Range[] res41 = range1.getUnion(range24);
        Range[] res42 = range1.getDifference(range24);

        Range res50 = range1.getIntersection(range25);
        Range[] res51 = range1.getUnion(range25);
        Range[] res52 = range1.getDifference(range25);

        Range res60 = range1.getIntersection(range26);
        Range[] res61 = range1.getUnion(range26);
        Range[] res62 = range1.getDifference(range26);

        Range res70 = range1.getIntersection(range27);
        Range[] res71 = range1.getUnion(range27);
        Range[] res72 = range1.getDifference(range27);

        Range res80 = range1.getIntersection(range28);
        Range[] res81 = range1.getUnion(range28);
        Range[] res82 = range1.getDifference(range28);

        Range res90 = range1.getIntersection(range29);
        Range[] res91 = range1.getUnion(range29);
        Range[] res92 = range1.getDifference(range29);

        Range res100 = range1.getIntersection(range210);
        Range[] res101 = range1.getUnion(range210);
        Range[] res102 = range1.getDifference(range210);


    }

}
