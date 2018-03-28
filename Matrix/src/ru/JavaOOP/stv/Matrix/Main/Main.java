package ru.JavaOOP.stv.Matrix.Main;

import ru.JavaOOP.stv.Matrix.Matrix;
import ru.JavaOOP.stv.Vector.Vector;

public class Main {
    public static void main(String[] args) {
        double[][] array1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double[][] array2 = {{7, 8, 9}, {1, 2, 3}, {6, 5, 4}};


        Matrix matrix0 = new Matrix(3, 3);
        Matrix matrix1 = new Matrix(array1);
        Matrix matrix2 = new Matrix(array2);
        Matrix matrix5 = new Matrix(matrix2);

        double[] array = {1, 6, 9};
        double[] array1_1 = {1, 7, 6};
        double[] array1_2 = {10, 11, 0};

        Vector[] vector = {new Vector(array), new Vector(array1_1), new Vector(array1_2)};
        Matrix matrix6 = new Matrix(vector);

        matrix2.subtract(matrix1);
        matrix1.add(matrix2);

        double determinant = matrix1.getDeterminant();
        Matrix matrix3 = matrix1;
        Matrix matrix2_t = matrix2.transpose();

        matrix1.multiply(2);
        Matrix matrix4 = Matrix.multiplication(matrix1, matrix3);


        System.out.println(matrix6.getRow(0));
        System.out.println(matrix4.toString());
        double[] arr6 = {34, 6.5, 11};
        Vector vec6 = new Vector(arr6);
        matrix6.setRow(vec6, 0);

        matrix5.multiply(vector[0]);
        Matrix matrix7 = Matrix.addition(matrix1, matrix2);
        double[] arr5 = {1, 2, 3};
        Vector vec5 = new Vector(arr5);
        matrix4.setRow(vec5, 2);

        Matrix matrix8 = Matrix.subtraction(matrix7, matrix1);
    }
}
