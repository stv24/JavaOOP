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
        if (head == null) {
            throw new NullPointerException("список пуст");
        }
        return head.getData();
    }

    private Node<T> getNode(int index) {

        if (index >= 0 && index <= (size - 1)) {
            int ind = 0;
            for (Node<T> p = head; p != null; p = p.getNext()) {
                if (ind == index) {
                    return p;
                }
                ind++;
            }
        }

        throw new IndexOutOfBoundsException("не существует элемента с таким индексом");
    }

    public T getData(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("не существует элемента с таким индексом");
        }
        Node<T> node = getNode(index);
        return node.getData();
    }

    public T setData(int index, T data) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("не существует элемента с таким индексом");
        }
        Node<T> node = getNode(index);
        T oldData = node.getData();
        node.setData(data);
        return oldData;
    }

    public void addFront(T data) {
        Node<T> node = new Node<>(data);
        node.setNext(head);
        head = node;
        ++size;
    }

    public T removeFront() {
        if (head == null) {
            throw new NullPointerException("список пуст");
        }
        T data = head.getData();
        head = head.getNext();
        --size;
        return data;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("не существует элемента с таким индексом");
        }
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
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("не существует элемента с таким индексом");
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
                if (prev == null) {
                    head = head.getNext();
                } else {
                    p = prev;
                    p.setNext(toDel.getNext());
                }
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

        if (head != null) {
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
        }

        return newList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (Node<T> p = head; p != null; p = p.getNext()) {
            sb.append((p.getData()).toString());
            sb.append(", ");
        }
        sb.delete(sb.length() - 2, sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MyList<?> myList = (MyList<?>) o;

        return (size == myList.size)
                && (head != null ? head.equals(myList.head) : myList.head == null);
    }

    @Override
    public int hashCode() {
        int result = head != null ? head.hashCode() : 0;
        result = 31 * result + size;
        return result;
    }
}
