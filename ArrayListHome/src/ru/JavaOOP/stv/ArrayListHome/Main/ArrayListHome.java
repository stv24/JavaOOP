package ru.JavaOOP.stv.ArrayListHome.Main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class ArrayListHome {
    public static void main(String[] args) throws IOException {

        ArrayList<String> strings = new ArrayList<>();
        Scanner scanner = new Scanner(new FileInputStream("strInput.txt"), "windows-1251");
        while (scanner.hasNextLine()) {
            strings.add(scanner.nextLine());
        }

        System.out.println(strings);
        ArrayList<Integer> ints = new ArrayList<>(Arrays.asList(1, 5, 2, 1, 3, 5, 4));
        Iterator<Integer> iterator = ints.iterator();

        while (iterator.hasNext()) {
            Integer value = iterator.next();
            if (value % 2 == 0) {
                iterator.remove();
            }
        }

        System.out.println(ints);

        ArrayList<Integer> ints2 = new ArrayList<>(Arrays.asList(1, 5, 2, 1, 3, 5));
        ArrayList<Integer> ints3 = new ArrayList<>();

        for (int i : ints2) {
            if (!ints3.contains(i)) {
                ints3.add(i);
            }
        }
        System.out.println(ints3);
    }

}
