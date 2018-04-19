package ru.JavaOOP.stv.MyList.ru.JavaOOP.stv.MyList.Main;

import ru.JavaOOP.stv.MyList.MyList;
import ru.JavaOOP.stv.MyList.Node;

public class Main {
    public static void main(String[] args) {
        Node<Integer> node = new Node<>(1);
        Node<Integer> node2 = new Node<>(null);

        MyList<Integer> list = new MyList<>();
        list.addFront(1);

        for (int i = 1; i < 4; ++i) {
            list.add(i, 1 + i);
        }

        list.add(1, 7);
        //list.add(2, null);

        list.invert();

        MyList<Integer> list2 = list.getCopy();
        boolean eq = list.equals(list2);

        Integer a = list.getFront();

        Integer b = list.getData(2);

        Integer old = list.setData(2, 10);

        Integer c = list.removeFront();

        Integer c2 = list.remove(3);
        Integer c3 = list.remove(0);

        boolean d = list.remove((Integer) 7);

        list2.addFront(20);
        list2.remove((Integer) 20);
        list2.add(0, -1);
        list2.addFront(null);
        list2.add(3, null);
        list2.invert();
        boolean d2 = list2.remove(null);

    }
}
