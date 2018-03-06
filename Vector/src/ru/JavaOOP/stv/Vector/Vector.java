package ru.JavaOOP.stv.Vector;

import java.util.Arrays;
import java.util.Objects;

public class Vector {
    private double[] vector;
    private int size;

    public double[] getVector() {
        return this.vector;
    }

    public int getSize() {
        return size;
    }

    public Vector(int n) {
        if (n <= 0) throw new IllegalArgumentException("неверноый размер вектора");
        vector = new double[n];
        size = n;
    }

    public Vector(Vector vector) {
        this.vector = Arrays.copyOf(vector.vector, vector.size);
        this.size = vector.getSize();
    }

    public Vector(double[] vector) {
        size = vector.length;
        this.vector = Arrays.copyOf(vector, size);
    }

    public Vector(int n, double[] vector) {
        this.size = n;
        this.vector = Arrays.copyOf(vector, n);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < size; ++i) {
            sb.append(vector[i]).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length() - 1);
        sb.append("}");

        return sb.toString();
    }

    public Vector add(Vector vector) {
        int n = Math.max(size, vector.size);
        Vector result = new Vector(n);
        if (this.size == vector.size) {
            for (int i = 0; i < n; ++i) {
                result.vector[i] = vector.vector[i] + this.vector[i];
            }
        } else if (this.size > vector.size) {
            double[] newVector = Arrays.copyOf(vector.vector, n);
            for (int i = 0; i < n; ++i) {
                result.vector[i] = newVector[i] + this.vector[i];
            }
        } else {
            double[] newVector = Arrays.copyOf(this.vector, n);
            for (int i = 0; i < n; ++i) {
                result.vector[i] = newVector[i] + this.vector[i];
            }
        }
        return result;
    }

    public Vector subtract(Vector vector) {
        int n = Math.max(size, vector.size);
        double[] result = new double[n];
        if (size == vector.size) {
            for (int i = 0; i < n; ++i) {
                result[i] = this.vector[i] - vector.vector[i];
            }
        } else if (size > vector.size) {
            double[] vec2 = Arrays.copyOf(vector.vector, n);
            for (int i = 0; i < n; ++i) {
                result[i] = this.vector[i] - vec2[i];
            }
        } else {
            double[] vec2 = Arrays.copyOf(this.vector, n);
            for (int i = 0; i < n; ++i) {
                result[i] = vec2[i] - vector.vector[i];
            }
        }

        return new Vector(result);
    }

    public Vector multiply(double number) {
        double[] result = new double[size];
        for (int i = 0; i < size; ++i) {
            result[i] = this.vector[i] * number;
        }
        return new Vector(result);
    }

    public Vector invert() {
        return multiply(-1);
    }

    public void setElementAt(int index, double number) {
        if (index < 0 || index > size - 1) throw new IllegalArgumentException("неверный индекс");
        vector[index] = number;
    }

    public double getElementAt(int index) {
        if (index < 0 || index > size - 1) throw new IllegalArgumentException("неверный индекс");
        return vector[index];
    }

    public int getLength() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector1 = (Vector) o;
        return size == vector1.size &&
                Arrays.equals(vector, vector1.vector);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(vector);
        return result;
    }

    public static Vector addition(Vector v1, Vector v2) {
        int n = Math.max(v1.size, v2.size);
        Vector result = new Vector(n);

        if (v1.size == v2.size) {
            for (int i = 0; i < n; ++i) {
                result.vector[i] = v1.vector[i] + v2.vector[i];
            }

        } else if (v1.size > v2.size) {
            Vector v22 = new Vector(n, v2.vector);
            for (int i = 0; i < n; ++i) {
                result.vector[i] = v1.vector[i] + v22.vector[i];
            }

        } else {
            Vector v11 = new Vector(n, v1.vector);
            for (int i = 0; i < n; ++i) {
                result.vector[i] = v11.vector[i] + v2.vector[i];
            }
        }
        return result;
    }

    public static Vector subtraction(Vector v1, Vector v2) {
        int n = Math.max(v1.size, v2.size);
        Vector result = new Vector(n);

        if (v1.size == v2.size) {
            for (int i = 0; i < n; ++i) {
                result.vector[i] = v1.vector[i] - v2.vector[i];
            }

        } else if (v1.size > v2.size) {
            Vector v22 = new Vector(n, v2.vector);
            for (int i = 0; i < n; ++i) {
                result.vector[i] = v1.vector[i] - v22.vector[i];
            }

        } else {
            Vector v11 = new Vector(n, v1.vector);
            for (int i = 0; i < n; ++i) {
                result.vector[i] = v11.vector[i] - v2.vector[i];
            }
        }
        return result;
    }

    public static double multiplication(Vector v1, Vector v2) {
        int n = Math.max(v1.size, v2.size);
        double result = 0;
        if (v1.size == v2.size) {
            for (int i = 0; i < n; ++i) {
                result += v1.vector[i] * v2.vector[i];
            }
        } else if (v1.size > v2.size) {
            Vector v22 = new Vector(n, v2.vector);
            for (int i = 0; i < n; ++i) {
                result += v1.vector[i] * v22.vector[i];
            }
        } else {
            Vector v11 = new Vector(n, v1.vector);
            for (int i = 0; i < n; ++i) {
                result += v11.vector[i] * v2.vector[i];
            }
        }
        return result;
    }

}

