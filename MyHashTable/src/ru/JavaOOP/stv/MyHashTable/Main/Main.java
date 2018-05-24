package ru.JavaOOP.stv.MyHashTable.Main;

import ru.JavaOOP.stv.MyHashTable.MyHashTable;

import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MyHashTable<Integer> intTable = new MyHashTable<>(15);
        MyHashTable<Integer> intTable0 = new MyHashTable<>(15);
        boolean eq = intTable.equals(intTable0);
        intTable.addAll(Arrays.asList(1, 10, null, 12, 7, null, 8, 7, 9));

        String stre = intTable.toString();
        intTable0.addAll(Arrays.asList(1, 10, 12, 7, 8, 7, 9));
        boolean eq2 = intTable.equals(intTable0);
        intTable.remove(127);
        intTable.add(127);
        Object[] elements = intTable.toArray();
        Object[] iElements = intTable.toArray(new Integer[4]);
        iElements = intTable.toArray(iElements);
        // String elstr = elements.toString();
        int size = intTable.size();
        String intTable1 = intTable.toString();


        Iterator<Integer> iterator = intTable.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        String str = intTable.toString();
        boolean change1 = intTable.removeAll(Arrays.asList(1, 2, 7));
        String intTable2 = intTable.toString();
        boolean change2 = intTable.retainAll(Arrays.asList(10, 8, 9, 22, 12, null));
        String intTable3 = intTable.toString();
        Iterator<Integer> iter = intTable.iterator();
        while(iter.hasNext()){
            iter.next();
            iter.remove();

        }
        //intTable.clear();
       String test =  intTable.toString();

    }
}
