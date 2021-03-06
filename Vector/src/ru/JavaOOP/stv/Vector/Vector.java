package ru.JavaOOP.stv.Vector;

import java.util.Arrays;


public class Vector {
    private double[] vector;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("неверноый размер вектора");
        }
        vector = new double[n];
    }

    public Vector(Vector vector) {
        this.vector = Arrays.copyOf(vector.vector, vector.getSize());
    }

    public Vector(double[] vector) {
        if (vector.length == 0) {
            throw new IllegalArgumentException("неверноый размер вектора");
        }
        this.vector = Arrays.copyOf(vector, vector.length);
    }

    public Vector(int n, double[] vector) {
        if (n <= 0) {
            throw new IllegalArgumentException("неверноый размер вектора");
        }
        this.vector = Arrays.copyOf(vector, n);
    }

    public int getSize() {
        return vector.length;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (double number : vector) {
            sb.append(number).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length() - 1);
        sb.append("}");

        return sb.toString();
    }

    public void add(Vector vector) {

        if (vector.getSize() > this.getSize()) {
            this.vector = Arrays.copyOf(this.vector, vector.getSize());
        }

        for (int i = 0; i < vector.getSize(); ++i) {
            this.vector[i] += vector.vector[i];
        }

    }

    public void subtract(Vector vector) {
        if (vector.getSize() > this.getSize()) {
            this.vector = Arrays.copyOf(this.vector, vector.getSize());
        }

        for (int i = 0; i < vector.getSize(); ++i) {
            this.vector[i] -= vector.vector[i];
        }
    }

    public void multiply(double number) {
        for (int i = 0; i < this.getSize(); ++i) {
            vector[i] *= number;
        }
    }

    public void invert() {
        multiply(-1);
    }

    public void setElementAt(int index, double number) {
        if (index < 0 || index >= this.getSize()) {
            throw new IndexOutOfBoundsException("неверный индекс");
        }
        vector[index] = number;
    }

    public double getElementAt(int index) {
        if (index < 0 || index >= this.getSize()) {
            throw new IndexOutOfBoundsException("неверный индекс");
        }
        return vector[index];
    }

    public double getLength() {
        double squareSum = 0;
        for (double number : vector) {
            squareSum += number * number;
        }
        return Math.sqrt(squareSum);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vector vector1 = (Vector) o;
        return Arrays.equals(vector, vector1.vector);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(vector);
    }

    public static Vector addition(Vector v1, Vector v2) {
        Vector result = new Vector(v1);
        result.add(v2);
        return result;
    }

    public static Vector subtraction(Vector v1, Vector v2) {
        Vector result = new Vector(v1);
        result.subtract(v2);
        return result;
    }

    public static double multiplication(Vector v1, Vector v2) {
        int n = Math.min(v1.getSize(), v2.getSize());
        double result = 0;
        for (int i = 0; i < n; ++i) {
            result += v1.vector[i] * v2.vector[i];
        }
        return result;
    }

}

