package ru.JavaOOP.stv.MyArrayList.Main;

import ru.JavaOOP.stv.MyArrayList.MyArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class Main {
    public  static void main(String[] args) {
        MyArrayList<Integer> iList = new MyArrayList<>(15);
        for (int i = 0; i < 5; ++i) {
            iList.add(i + 2);
        }

        iList.add(2, -1);
        Object[] a = iList.toArray();

        Integer[] c = new Integer[iList.size()];
        c = iList.toArray(c);
        c[0] = -100;

        int el = iList.get(4);
        iList.trimToSize();
        MyArrayList<Integer> iList2 = new MyArrayList<>(5);
        for (int i = 0; i < 5; ++i) {
            iList2.add(100 + i);
        }

        iList.addAll(iList2);
        iList.removeAll(iList2);

        MyArrayList<String> strList1 = new MyArrayList<>(3);
        strList1.add("White");
        strList1.add("Black");
        strList1.add("Red");
        strList1.ensureCapacity(5);

        ArrayList<String> collection = new ArrayList<>(Arrays.asList("White", "Green", "Red"));

        MyArrayList<String> strList2 = new MyArrayList<>(3);
        strList2.addAll(collection);
        strList1.retainAll(collection);
        strList2.retainAll(strList1);

        String d = strList1.set(0, "green");
        if (strList1.contains("green")) {
            System.out.println("green");
        } else {
            System.out.println("no such element in list");
        }

        iList.clear();
        if (iList.isEmpty()) {
            iList.addAll(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)));

        }

        int index = iList.indexOf(4);

        Iterator<Integer> it = iList.iterator();
        while (it.hasNext()) {
            if(it.next()%2 == 0){
                it.remove();
            }
        }

        iList.addAll(new ArrayList<>(Arrays.asList(8, 10, 12, 14)));
        ListIterator<Integer> listIt = iList.listIterator();
        while (listIt.hasNext()){
            int value = listIt.next();
            if (value % 2 == 0) {
                listIt.remove();
                listIt.add(value + 1);
            }

            if (value == 1) {
                listIt.set(value + 7);
            }

        }

        ListIterator<Integer> listIt2 = iList.listIterator(iList.size());
        while (listIt.hasPrevious()){
            int value = listIt2.previous();
            if (value % 2 != 0) {
                listIt2.remove();
                //listIt2.add(value + 1);
            }

            if (value == 8) {
                listIt2.set(value + 7);
            }

        }

    }


}
