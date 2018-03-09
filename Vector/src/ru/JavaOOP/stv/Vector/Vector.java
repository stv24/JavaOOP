package ru.JavaOOP.stv.Vector;

import java.util.Arrays;


public class Vector {
    private double[] vector;


    public double[] getVector() {
        return this.vector;
    }

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("неверноый размер вектора");
        }
        vector = new double[n];

    }

    public Vector(Vector vector) {
        this.vector = Arrays.copyOf(vector.vector, vector.getLength());
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

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (double i : vector) {
            sb.append(i).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length() - 1);
        sb.append("}");

        return sb.toString();
    }

    public void add(Vector vector) {
        int n = Math.max(this.vector.length, vector.getLength());
        if (this.getLength() == vector.getLength()) {
            for (int i = 0; i < n; ++i) {
                this.vector[i] += vector.vector[i];
            }
        } else if (this.getLength() > vector.getLength()) {
            double[] newVector = Arrays.copyOf(vector.vector, n);
            for (int i = 0; i < n; ++i) {
                this.vector[i] = newVector[i] + this.vector[i];
            }
        } else {
            this.vector = Arrays.copyOf(this.vector, n);
            for (int i = 0; i < n; ++i) {
                this.vector[i] = this.vector[i] + vector.vector[i];
            }
        }

    }

    public void subtract(Vector vector) {
        int n = Math.max(this.getLength(), vector.getLength());
        if (this.getLength() == vector.getLength()) {
            for (int i = 0; i < n; ++i) {
                this.vector[i] -= vector.vector[i];
            }
        } else if (this.getLength() > vector.getLength()) {
            double[] vec2 = Arrays.copyOf(vector.vector, n);
            for (int i = 0; i < n; ++i) {
                this.vector[i] -= vec2[i];
            }
        } else {
            this.vector = Arrays.copyOf(this.vector, n);
            for (int i = 0; i < n; ++i) {
                this.vector[i] -= vector.vector[i];
            }
        }
    }

    public void multiply(double number) {
        for (int i = 0; i < this.getLength(); ++i) {
            vector[i] *= number;
        }
    }

    public void invert() {
        multiply(-1);
    }

    public void setElementAt(int index, double number) {
        if (index < 0 || index > this.getLength() - 1) throw new IllegalArgumentException("неверный индекс");
        vector[index] = number;
    }

    public double getElementAt(int index) {
        if (index < 0 || index > this.getLength() - 1) throw new IllegalArgumentException("неверный индекс");
        return vector[index];
    }

    public int getLength() {
        return this.vector.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector1 = (Vector) o;
        return Arrays.equals(getVector(), vector1.getVector());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(getVector());
    }

    public static Vector addition(Vector v1, Vector v2) {
        int n = Math.max(v1.getLength(), v2.getLength());
        Vector result = new Vector(n);
        result.vector = Arrays.copyOf(v1.vector, n);
        result.add(v2);
        return result;
    }

    public static Vector subtraction(Vector v1, Vector v2) {
        int n = Math.max(v1.getLength(), v2.getLength());
        Vector result = new Vector(n);
        result.vector = Arrays.copyOf(v1.vector, n);
        result.subtract(v2);
        return result;
    }

    public static double multiplication(Vector v1, Vector v2) {
        int n = Math.max(v1.getLength(), v2.getLength());
        double result = 0;
        if (v1.getLength() == v2.getLength()) {
            for (int i = 0; i < n; ++i) {
                result += v1.vector[i] * v2.vector[i];
            }
        } else if (v1.getLength() > v2.getLength()) {
            double[] array = Arrays.copyOf(v2.vector, n);
            for (int i = 0; i < n; ++i) {
                result += v1.vector[i] * array[i];
            }
        } else {
            double[] array = Arrays.copyOf(v1.vector, n);
            for (int i = 0; i < n; ++i) {
                result += array[i] * v2.vector[i];
            }
        }
        return result;
    }

}

