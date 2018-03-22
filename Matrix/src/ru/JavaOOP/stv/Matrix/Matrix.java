package ru.JavaOOP.stv.Matrix;

import ru.JavaOOP.stv.Vector.Vector;

import java.util.Arrays;


public class Matrix {
    private Vector[] matrix;

    public Matrix(int n, int m) {
        if (n <= 0 || m <= 0) {
            throw new IllegalArgumentException("неверные параметры матрицы");
        }

        matrix = new Vector[n];
        for (int i = 0; i < n; ++i) {
            matrix[i] = new Vector(m);
        }

    }

    public Matrix(Matrix matrix) {
        this.matrix = new Vector[matrix.getSize()];
        System.arraycopy(matrix.matrix, 0, this.matrix, 0, matrix.getSize());

    }

    public Matrix(double[][] array) {
        int n = array.length;
        int m = array[0].length;

        matrix = new Vector[n];

        for (int i = 0; i < n; ++i) {
            double[] row = new double[m];
            System.arraycopy(array[i], 0, row, 0, m);
            matrix[i] = new Vector(row);
        }

    }

    public Matrix(Vector vector) {
        matrix = new Vector[1];
        matrix[0] = new Vector(vector);

    }

    private int getSize() {
        return matrix.length;
    }

    public String getVector(int index) {
        return matrix[index].toString();
    }

    public void setVector(Vector vector, int index) {
        if (index < 0 || index >= matrix.length) {
            throw new IndexOutOfBoundsException("указан неверный индекс");
        }

        if (vector.getSize() != matrix[0].getSize()) {
            throw new IllegalArgumentException("неверный размер вектора");
        }

        matrix[index] = new Vector(vector);

    }

    private Vector getColumn(int index) {
        if (index < 0 || index >= matrix[0].getSize()) {
            throw new IllegalArgumentException("указан неверный индекс");
        }
        Vector tempRow = new Vector(matrix.length);
        for (int i = 0; i < matrix.length; ++i) {
            tempRow.setElementAt(i, matrix[i].getElementAt(index));
        }
        return tempRow;
    }

    public void transpose() {

        for (int i = 0; i < matrix.length; ++i) {
            int rowIndex = 0;
            for (int j = 0; j < matrix[0].getSize(); ++j) {
                if (rowIndex >= matrix.length) {
                    continue;
                }
                matrix[i].setElementAt(j, matrix[rowIndex].getElementAt(i));
                rowIndex++;
            }
        }
    }

    public void multiply(double value) {
        for (Vector vector : matrix) {
            vector.multiply(value);
        }
    }

    public double getDeterminant() {
        int order = matrix.length;
        double multiplier = 1;
        Vector[] matrix2 = new Vector[order];
        for (int i = 0; i < order; ++i) {
            matrix2[i] = new Vector(matrix[i]);
        }

        int start = 0;
        while (start < order - 1) {
            for (int i = start; i < order; ++i) {
                if (i == start) {
                    if (matrix2[start].getElementAt(start) == 0) {
                        int rowInd = start;
                        while (matrix2[rowInd + 1].getElementAt(start) == 0) {
                            rowInd++;
                        }
                        for (int k = 0; k < order; ++k) {
                            matrix2[start].setElementAt(k, matrix2[start].getElementAt(k) + matrix2[rowInd + 1].getElementAt(k));
                        }
                    }
                    i++;
                }
                double a = -matrix2[i].getElementAt(start) / matrix2[start].getElementAt(start);
                for (int j = start; j < order; ++j) {
                    matrix2[i].setElementAt(j, matrix2[i].getElementAt(j) + matrix2[start].getElementAt(j) * a);
                }
            }
            multiplier *= matrix2[start].getElementAt(start);
            ++start;
        }
        return multiplier * matrix2[order - 1].getElementAt(order - 1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (Vector v : matrix) {
            String vector = v.toString();
            sb.append(vector);
            sb.append(", ");
        }
        sb.delete(sb.length() - 2, sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }

    public void multiply(Vector vector) {
        if (vector.getSize() != matrix[0].getSize()) {
            throw new IllegalArgumentException("неверный размер вектора");
        }

        for (int i = 0; i < matrix.length; ++i) {
            double sum = Vector.multiplication(matrix[i], vector);
            matrix[i] = new Vector(1);
            matrix[i].setElementAt(0, sum);
        }
    }

    public void add(Matrix matrix2) {
        if (matrix2.getSize() != matrix.length || matrix2.matrix[0].getSize() != matrix[0].getSize()) {
            throw new IllegalArgumentException("матрицы должны быть одинаковой размерности");
        }
        for (int i = 0; i < getSize(); ++i) {
            matrix[i].add(matrix2.matrix[i]);
        }

    }

    public void subtract(Matrix matrix2) {
        if (matrix2.getSize() != matrix.length || matrix2.matrix[0].getSize() != matrix[0].getSize()) {
            throw new IllegalArgumentException("матрицы должны быть одинаковой размерности");
        }
        for (int i = 0; i < getSize(); ++i) {
            matrix[i].subtract(matrix2.matrix[i]);
        }
    }

    public static Matrix subtraction(Matrix matrix1, Matrix matrix2) {
        if (matrix2.getSize() != matrix1.getSize() || matrix2.matrix[0].getSize() != matrix1.matrix[0].getSize()) {
            throw new IllegalArgumentException("матрицы должны быть одинаковой размерности");
        }

        Matrix result = new Matrix(matrix1.getSize(), matrix1.matrix[0].getSize());
        for (int i = 0; i < result.getSize(); ++i) {
            result.matrix[i] = Vector.subtraction(matrix1.matrix[i], matrix2.matrix[i]);
        }
        return result;
    }

    public static Matrix addition(Matrix matrix1, Matrix matrix2) {
        if (matrix2.getSize() != matrix1.getSize() || matrix2.matrix[0].getSize() != matrix1.matrix[0].getSize()) {
            throw new IllegalArgumentException("матрицы должны быть одинаковой размерности");
        }

        Matrix result = new Matrix(matrix1.getSize(), matrix1.matrix[0].getSize());
        for (int i = 0; i < result.getSize(); ++i) {
            result.matrix[i] = Vector.addition(matrix1.matrix[i], matrix2.matrix[i]);
        }
        return result;
    }

    public static Matrix multiplication(Matrix matrix1, Matrix matrix2) {
        if (matrix1.matrix[0].getSize() != matrix2.getSize()) {
            throw new IllegalArgumentException("неверные размеры матриц");
        }

        Matrix result = new Matrix(matrix1.getSize(), matrix1.matrix[0].getSize());
        for (int i = 0; i < result.getSize(); ++i) {
            for (int j = 0; j < result.matrix[0].getSize(); ++j) {
                Vector column = matrix2.getColumn(j);
                double value = Vector.multiplication(matrix1.matrix[i], column);
                result.matrix[i].setElementAt(j, value);
            }

        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Matrix matrix1 = (Matrix) o;
        return Arrays.equals(matrix, matrix1.matrix);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(matrix);
    }


}
