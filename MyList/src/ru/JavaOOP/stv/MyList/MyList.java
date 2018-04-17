package ru.JavaOOP.stv.MyList;

public class MyList<T> {
    private Node<T> head;
    private int size = 0;

    public MyList() {

    }

    public int getSize() {
        return size;
    }

    public T getFront() {
        return head.getData();
    }

    public T getData(int index) {
        int ind = 0;

        for (Node<T> p = head; p != null; p = p.getNext()) {
            if (ind == index) {
                return p.getData();
            }
            ind++;
        }
        throw new IndexOutOfBoundsException("не существует элемента по указанном индексу");
    }

    public T setData(int index, T data) {
        int ind = 0;

        for (Node<T> p = head; p != null; p = p.getNext()) {
            if (ind == index) {
                T oldData = p.getData();
                p.setData(data);
                return oldData;
            }
            ind++;
        }
        throw new IndexOutOfBoundsException("не существует элемента по указанном индексу");

    }

    public void addFront(T data) {
        Node<T> node = new Node<>(data);
        node.setNext(head);
        head = node;
        ++size;
    }

    public T removeFront() {
        T data = head.getData();
        head = head.getNext();
        --size;
        return data;
    }

    public T remove(int index) {
        int ind = 0;
        T data = null;
        for (Node<T> p = head; p != null; p = p.getNext()) {
            if (ind == index - 1) {
                Node<T> toDel = p.getNext();
                p.setNext(toDel.getNext());
                data = toDel.getData();
            }
            ind++;
        }
        --size;
        return data;
    }

    public void add(int index, T element) {
        if (element == null) {
            throw new NullPointerException("пустое значение");
        }
        Node<T> node = new Node<>(element);
        int ind = 0;

        for (Node<T> p = head; p != null; p = p.getNext()) {
            if (ind == index - 1) {
                if (p.getNext() != null) {
                    node.setNext(p.getNext());
                }
                p.setNext(node);
            }
            ind++;
        }
        ++size;

    }

    public boolean remove(T element) {
        for (Node<T> p = head, prev = null; p != null; prev = p, p = p.getNext()) {
            if (p.getData().equals(element)) {
                Node<T> toDel = p;
                p = prev;
                p.setNext(toDel.getNext());
                --size;
                return true;
            }
        }
        return false;
    }

    public void invert() {

        Node<T> prev = null;
        Node<T> current = head;

        while (current != null) {
            Node<T> next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        head = prev;
    }

    public MyList<T> getCopy() {
        MyList<T> newList = new MyList<>();
        Node<T> node = head;
        Node<T> copy = new Node<>(node.getData(), node.getNext());
        Node<T> head2 = copy;

        while (node.getNext() != null) {
            Node<T> next = new Node<>((node.getNext()).getData(), (node.getNext()).getNext());
            copy.setNext(next);
            node = node.getNext();
            copy = copy.getNext();
        }
        newList.head = head2;
        newList.size = size;
        return newList;
    }


}
