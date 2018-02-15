package ru.JavaOOP.stv.Range;

public class Range2 {
    private double from;
    private double to;

    public Range2(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getLength() {
        return (to - from);
    }

    public Range2 getIntersection(Range2 range2) {


        boolean isIntersection = (isInside(range2.from) || isInside(range2.to)) || (range2.isInside(this.from) || range2.isInside(this.to)) ;

        if (isIntersection) {
            if (isInside(range2.from) && isInside(range2.to)) {
                return range2;
            } else if (range2.isInside(this.from) && range2.isInside(this.to)) {
                return this;
            } else if (isInside(range2.from) && !isInside(range2.to)) {
                return new Range2(range2.from, this.to);
            } else {
                return new Range2(this.from, range2.to);
            }
        } else {
            return null;
        }
    }

    public Range2[] getUnion(Range2 range2) {

        if ((!isInside(range2.from) && !isInside(range2.to)) && (!range2.isInside(this.from) && !range2.isInside(this.to))) {
            Range2[] range = new Range2[2];
            range[0] = this;
            range[1] = range2;
            return range;

        } else if (this == range2) {
            Range2[] range = new Range2[1];
            range[0] = this;
            return range;

        } else {
            Range2[] range = new Range2[1];
            double from = this.from < range2.from ? this.from : range2.from;
            double to = this.to < range2.to ? range2.to : this.to;
            range[0] = new Range2(from, to);
            return range;

        }
    }

    public Range2[] getDifference(Range2 range2) {
        double epsilon = 1e-5;
        if (this.from == range2.from && this.to == range2.to) {
            return null;
        } else if (isInside(range2.from) && !isInside(range2.to)) {
            Range2[] range = new Range2[1];
            range[0] = new Range2(this.from, range2.from - epsilon);
            return range;

        } else if (isInside(range2.from) && isInside(range2.to)) {
            Range2[] range = new Range2[2];
            range[0] = new Range2(this.from, range2.from - epsilon);
            range[1] = new Range2(range2.to + epsilon, this.to);
            return range;

        } else if (isInside(range2.to) && !isInside(range2.from)) {
            Range2[] range = new Range2[1];
            range[0] = new Range2(range2.to + epsilon, this.to);
            return range;

        } else if (range2.from > this.to || this.from > range2.to) {
            Range2[] range = new Range2[1];
            range[0] = this;
            return range;
        } else {
            return null;
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
