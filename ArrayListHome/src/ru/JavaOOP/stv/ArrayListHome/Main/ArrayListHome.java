package ru.JavaOOP.stv.ArrayListHome.Main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayListHome {
    public static void main(String[] args) throws IOException {
        ArrayList<String> strings = new ArrayList<>();
        Scanner scanner = new Scanner(new FileInputStream("strInput.txt"), "windows-1251");
        while (scanner.hasNextLine()) {
            strings.add(scanner.nextLine());
        }

        System.out.println(strings);
        ArrayList<Integer> ints = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        for (int i = 0; i < ints.size(); ++i) {
            if (ints.get(i) % 2 == 0) {
                ints.remove(i);
            }

        }

        ArrayList<Integer> ints2 = new ArrayList<>(Arrays.asList(1, 2, 3, 3, 4, 5, 6, 7, 8, 8));
        ArrayList<Integer> ints3 = new ArrayList<>();

        for (int i : ints2) {
            if (!ints3.contains(i)) {
                ints3.add(i);
            }
        }
        System.out.println(ints3);
    }

}
