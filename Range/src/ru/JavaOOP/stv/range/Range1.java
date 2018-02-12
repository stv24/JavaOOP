package ru.JavaOOP.stv.range;

import java.util.Scanner;

public class Range1 {
    private double from;
    private double to;

    public Range1(double from, double to) {
        if (from > to) {
            double temp = this.from;
            this.from = this.to;
            this.to = temp;
        } else {
            this.from = from;
            this.to = to;
        }
    }

    public double getLength() {
        if (to < from) {
            double temp = from;
            from = to;
            to = temp;
        }
        return (to - from);
    }

    public boolean isInside(double number) {
        return (((number - from) >= 0) && ((number - to) <= 0));
    }

    public void setTo(double to) {
        this.to = to;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public double getFrom() {
        return from;
    }

    public static void main(String[] args) {
        Range1 range = new Range1(5, 10);
        for (; ; ) {
            System.out.println("Введите начало диапазона:");
            Scanner scanner = new Scanner(System.in);
            double from = scanner.nextDouble();
            System.out.println("Введите последнее число диапазона:");
            double to = scanner.nextDouble();
            System.out.println("Введите число");
            double number = scanner.nextDouble();

            range.setFrom(from);
            range.setTo(to);

            if (range.getFrom() > range.getTo()) {
                System.out.println("Перепутаны границы диапазона");
            }

            double length = range.getLength();
            System.out.printf("Длина интервала %f%n", length);
            String str = range.isInside(number) ? "Число попадает в указанный интервал" : "Число не попадает в указанный интервал";
            System.out.println(str);
            if (!range.isInside(number)) {
                break;
            }
        }
    }
}
