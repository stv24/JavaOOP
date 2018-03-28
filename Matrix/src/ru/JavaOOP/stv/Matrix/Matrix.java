package ru.JavaOOP.stv.Matrix;

import ru.JavaOOP.stv.Vector.Vector;

import java.util.Arrays;


public class Matrix {
    private Vector[] rows;

    public Matrix(int rowsCount, int columnsCount) {
        if (rowsCount <= 0 || columnsCount <= 0) {
            throw new IllegalArgumentException("неверные параметры матрицы");
        }

        rows = new Vector[rowsCount];
        for (int i = 0; i < rowsCount; ++i) {
            rows[i] = new Vector(columnsCount);
        }

    }

    public Matrix(Matrix matrix) {

        this.rows = new Vector[matrix.getRowsCount()];
        for (int i = 0; i < matrix.getRowsCount(); ++i) {
            this.rows[i] = new Vector(matrix.rows[i]);
        }
    }

    public Matrix(double[][] array) {
        int rowCount = array.length;

        if (rowCount == 0) {
            throw new IllegalArgumentException("размер массива 0");
        }

        int columnCount = array[0].length;
        for (double[] i : array) {
            if (i.length > columnCount) {
                columnCount = i.length;
            }
        }

        rows = new Vector[rowCount];
        for (int i = 0; i < rowCount; ++i) {
            rows[i] = new Vector(Arrays.copyOf(array[i], columnCount));
        }
    }

    public Matrix(Vector[] vectors) {
        if (vectors.length == 0) {
            throw new IllegalArgumentException("размер вектора 0");
        }
        int size = vectors[0].getSize();

        this.rows = new Vector[vectors.length];
        for (int i = 0; i < vectors.length; ++i) {
            if (vectors[i].getSize() != size) {
                throw new IllegalArgumentException("вектора должны быть одинаковой длины");
            }
            this.rows[i] = new Vector(vectors[i]);
        }
    }


    private int getRowsCount() {
        return rows.length;
    }

    private int getColumnsCount() {
        return rows[0].getSize();
    }

    public Vector getRow(int index) {
        if (index < 0 || index >= rows.length) {
            throw new IndexOutOfBoundsException("указан неверный индекс");
        }
        return new Vector(rows[index]);
    }

    public void setRow(Vector vector, int index) {
        if (index < 0 || index >= rows.length) {
            throw new IndexOutOfBoundsException("указан неверный индекс");
        }

        if (vector.getSize() != rows[0].getSize()) {
            throw new IllegalArgumentException("неверный размер вектора");
        }

        rows[index] = new Vector(vector);

    }

    private Vector getColumn(int index) {
        if (index < 0 || index >= getColumnsCount()) {
            throw new IllegalArgumentException("указан неверный индекс");
        }
        Vector tempRow = new Vector(getRowsCount());
        for (int i = 0; i < rows.length; ++i) {
            tempRow.setElementAt(i, rows[i].getElementAt(index));
        }
        return tempRow;
    }

    public Matrix transpose() {
        Matrix result = new Matrix(getColumnsCount(), getRowsCount());
        for (int i = 0; i < getColumnsCount(); ++i) {
            for (int j = 0; j < getRowsCount(); ++j) {
                result.rows[i].setElementAt(j, rows[j].getElementAt(i));
            }
        }
        return result;
    }

    public void multiply(double value) {
        for (Vector vector : rows) {
            vector.multiply(value);
        }
    }

    public double getDeterminant() {
        int order = rows.length;
        double multiplier = 1;
        Vector[] matrix2 = new Vector[order];
        for (int i = 0; i < order; ++i) {
            matrix2[i] = new Vector(rows[i]);
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
        for (Vector v : rows) {
            String vector = v.toString();
            sb.append(vector);
            sb.append(", ");
        }
        sb.delete(sb.length() - 2, sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }

    public Vector multiply(Vector vector) {
        if (vector.getSize() != rows[0].getSize()) {
            throw new IllegalArgumentException("неверный размер вектора");
        }

        Vector result = new Vector(getRowsCount());
        for (int i = 0; i < rows.length; ++i) {
            double sum = Vector.multiplication(rows[i], vector);
            result.setElementAt(i, sum);
        }
        return result;
    }

    public void add(Matrix matrix2) {
        if (matrix2.getRowsCount() != rows.length || matrix2.getColumnsCount() != getColumnsCount()) {
            throw new IllegalArgumentException("матрицы должны быть одинаковой размерности");
        }
        for (int i = 0; i < getRowsCount(); ++i) {
            rows[i].add(matrix2.rows[i]);
        }

    }

    public void subtract(Matrix matrix2) {
        if (matrix2.getRowsCount() != rows.length || matrix2.getColumnsCount() != getColumnsCount()) {
            throw new IllegalArgumentException("матрицы должны быть одинаковой размерности");
        }
        for (int i = 0; i < getRowsCount(); ++i) {
            rows[i].subtract(matrix2.rows[i]);
        }
    }

    public static Matrix subtraction(Matrix matrix1, Matrix matrix2) {
        if (matrix2.getRowsCount() != matrix1.getRowsCount() || matrix2.getColumnsCount() != matrix1.getColumnsCount()) {
            throw new IllegalArgumentException("матрицы должны быть одинаковой размерности");
        }
        matrix1.subtract(matrix2);

        return new Matrix(matrix1);
    }

    public static Matrix addition(Matrix matrix1, Matrix matrix2) {
        if (matrix2.getRowsCount() != matrix1.getRowsCount() || matrix2.getColumnsCount() != matrix1.getColumnsCount()) {
            throw new IllegalArgumentException("матрицы должны быть одинаковой размерности");
        }
        matrix1.add(matrix2);
        return new Matrix(matrix1);
    }

    public static Matrix multiplication(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsCount() != matrix2.getRowsCount()) {
            throw new IllegalArgumentException("неверные размеры матриц");
        }

        Matrix result = new Matrix(matrix1.getRowsCount(), matrix1.rows[0].getSize());
        for (int i = 0; i < result.getRowsCount(); ++i) {
            for (int j = 0; j < result.getColumnsCount(); ++j) {
                Vector column = matrix2.getColumn(j);
                double value = Vector.multiplication(matrix1.rows[i], column);
                result.rows[i].setElementAt(j, value);
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
        return Arrays.equals(rows, matrix1.rows);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(rows);
    }
}
