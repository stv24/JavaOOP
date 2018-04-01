package ru.JavaOOP.stv.Matrix.Main;

import ru.JavaOOP.stv.Matrix.Matrix;
import ru.JavaOOP.stv.Vector.Vector;

public class Main {
    public static void main(String[] args) {
        double[][] array1_0 = {{2, 4, 1, 1}, {0, 2, 0, 0}, {2, 1, 1, 3}, {4, 0, 2, 3}};
        Matrix matrix1_0 = new Matrix(array1_0);
        System.out.println(matrix1_0.getDeterminant());

        double[][] matrix = {{0, 3, -1, 2, 6}, {2, 1, 0, 0, 3}, {-2, -1, 0, 2, 5}, {-5, 7, 1, 1, 1}, {2, 0, 2, -2, 1}};
        Matrix matrix1_1 = new Matrix(matrix);
        double[][] arr = {{1, 3, 10, 2, 2, 3, 3}, {-1, 1, 0, 0, 3, 1, 1}, {5, 5, -2, 1, 1, 5, 7}, {17, -4, 4, 1, 1, -4, 7}, {-3, 2, 13, 1, -2, 2, -1}, {-2, 2, 0, 0, 6, 2, 2}, {0, -2, 0, 5, -3, -2, 3}};

        Matrix matrix1_2 = new Matrix(arr);
        System.out.println(matrix1_1.getDeterminant());
        System.out.println(matrix1_2.getDeterminant());

        double[][] array1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {2, 2, 7}};
        double[][] array2 = {{7, 8, 9}, {1, 2, 3}, {6, 5, 4}};
        Matrix matrix0 = new Matrix(3, 3);
        Matrix matrix1 = new Matrix(array1);
        matrix1.transpose();
        Matrix matrix2 = new Matrix(array2);


        double[][] mult1 = {{-1, 1}, {2, 0}, {0, 3}};
        double[][] mult2 = {{3, 1, 2}, {0, -1, 4}};
        Matrix m1 = new Matrix(mult1);
        Matrix m2 = new Matrix(mult2);

        Matrix m3 = Matrix.multiplication(m1, m2);
        m2.transpose();
        m2.subtract(m1);
        m1.add(m2);

        double determinant = matrix1.getDeterminant();
        Matrix matrix3 = new Matrix(matrix1);
        matrix2.transpose();

        matrix1.multiply(2);
        matrix3.transpose();
        Matrix matrix4 = Matrix.multiplication(matrix1, matrix3);
        Matrix matrix5 = new Matrix(matrix2);

        double[] array = {1, 6, 9};
        Vector vector = new Vector(array);

        System.out.println(matrix4.toString());
        double[] arr6 = {34, 6.5, 11};
        Vector vec6 = new Vector(arr6);


        matrix5.multiply(vector);
        matrix2.transpose();
        Matrix matrix7 = Matrix.addition(m1, m2);
        double[] arr5 = {1, 2, 3};
        Vector vec5 = new Vector(arr5);
        double[] arr1 = {1};
        Vector vec1 = new Vector(arr1);
        Vector[] vectors = {vec1, vec5};
        Matrix vecMatrix = new Matrix(vectors);
        Matrix matrix8 = Matrix.subtraction(m1, m2);

    }
}
