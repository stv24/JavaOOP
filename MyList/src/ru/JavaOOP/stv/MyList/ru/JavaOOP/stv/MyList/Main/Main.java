package ru.JavaOOP.stv.MyList.ru.JavaOOP.stv.MyList.Main;

import ru.JavaOOP.stv.MyList.MyList;
import ru.JavaOOP.stv.MyList.Node;

public class Main {
    public static void main(String[] args) {
        Node<Integer> node = new Node<>(1);
        MyList<Integer> list = new MyList<>();
        list.addFront(1);

        for (int i = 1; i < 4; ++i) {
            list.add(i, 1 + i);
        }

        list.add(1, 7);

        list.invert();

        MyList<Integer> list2 = list.getCopy();

        Integer a = list.getFront();

        Integer b = list.getData(2);

        Integer old = list.setData(2, 10);

        Integer c = list.removeFront();

        Integer c2 = list.remove(3);

        boolean d = list.remove((Integer) 7);

        list2.addFront(20);
        list2.remove((Integer) 20);


    }
}
