package ru.JavaOOP.stv.Range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getLength() {
        return (to - from);
    }

    public Range getIntersection(Range range2) {
        if (range2.from >= this.from && range2.to <= this.to) {
            return new Range(range2.from, range2.to);

        } else if (this.from >= range2.from && this.to <= range2.to) {
            return new Range(this.from, this.to);

        } else if (range2.from >= this.from && range2.from <= this.to && range2.to >= this.to) {
            return new Range(range2.from, this.to);

        } else if (range2.from <= this.from && range2.to <= this.to && range2.to >= this.from) {
            return new Range(this.from, range2.to);

        } else {
            return null;
        }
    }

    public Range[] getUnion(Range range2) {

        if ((range2.from < this.from && range2.to < this.from) || (range2.from > this.to && range2.to > this.to)) {
            return new Range[]{new Range(this.from, this.to), new Range(range2.from, range2.to)};
        } else if (this == range2) {
            return new Range[]{this};

        } else {
            double from = this.from < range2.from ? this.from : range2.from;
            double to = this.to < range2.to ? range2.to : this.to;
            return new Range[]{new Range(from, to)};

        }
    }

    public Range[] getDifference(Range range2) {

        if (this.from == range2.from && this.to == range2.to) {
            return new Range[0];

        } else if (range2.from >= this.from && range2.from <= this.to && range2.to > this.to) {
            return new Range[]{new Range(this.from, this.from)};

        } else if (range2.from >= this.from && range2.to <= this.to) {
            return new Range[]{new Range(this.from, this.from), new Range(this.to, this.to)};

        } else if (range2.to >= this.from && range2.to <= this.to && range2.from < this.from) {
            return new Range[]{new Range(this.to, this.to)};

        } else if (range2.from > this.to || this.from > range2.to) {
            return new Range[]{new Range(this.to, this.to)};

        } else {
            return new Range[0];
        }
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