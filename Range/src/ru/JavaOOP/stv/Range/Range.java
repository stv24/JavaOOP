package ru.JavaOOP.stv.Range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        if (from > to) {
            System.out.println("Перепутаны границы диапазона");
        } else {
            this.from = from;
            this.to = to;
        }
    }

    public double getLength() {
        return (to - from);
    }

    public boolean isInside(double number) {
        return (number >= from && number <= to);
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

}
