package ru.JavaOOP.stv.Range;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Range range = new Range(5, 10);
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
