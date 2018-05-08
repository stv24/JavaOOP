package ru.JavaOOP.stv.MyArrayList;


import java.util.*;

public class MyArrayList<E> implements List<E> {
    private int length;
    private int modCount;
    private E[] items;


    @SuppressWarnings("unchecked")
    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("неверная емкость");
        }
        items = (E[]) new Object[capacity];
        length = 0;
        modCount = 0;
    }

    public void clear() {
        length = 0;
        modCount++;
    }

    public Object[] toArray() {
        return Arrays.copyOf(items, length);
    }

    public E get(int index) {
        if (index >= length || index < 0) {
            throw new IndexOutOfBoundsException("такого эдемента не существует");
        }
        return items[index];
    }

    public boolean addAll(int index, Collection<? extends E> c) {

        if (c == null) {
            throw new NullPointerException("пустая коллекция");
        }
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException("выход за границы массива");

        }

        Object[] cArray = c.toArray();
        if (cArray.length == 0) {
            return false;
        }

        int minSize = size() + cArray.length;
        ensureCapacity(minSize);
        if (index < size()) {
            System.arraycopy(items, index, items, index + cArray.length, size() - index);
        }
        System.arraycopy(cArray, 0, items, index, cArray.length);
        length += cArray.length;
        ++modCount;
        return true;
    }

    private class MyIterator implements Iterator<E> {
        private int currentIndex = -1;
        private int currentModCount;

        private MyIterator() {
            currentModCount = MyArrayList.this.modCount;
        }

        public void remove() {
            MyArrayList.this.remove(currentIndex);
            currentModCount = MyArrayList.this.modCount;
        }

        public E next() {
            if (currentIndex >= size()) {
                throw new NoSuchElementException("не существует такого элемента");
            }

            if (currentModCount != MyArrayList.this.modCount) {
                throw new ConcurrentModificationException("изменение коллекции за время обхода");
            }
            ++currentIndex;
            return items[currentIndex];
        }

        public boolean hasNext() {
            return currentIndex + 1 < length;
        }
    }

    private class MyListIterator implements ListIterator<E> {
        private int currentIndex = -1;
        private int currentModCount;

        private MyListIterator() {
            currentModCount = MyArrayList.this.modCount;
        }

        private MyListIterator(int index) {
            if (index > MyArrayList.this.size() || index < 0) {
                throw new IndexOutOfBoundsException("указан неверный индекс");

            }
            currentIndex = index;
            currentModCount = MyArrayList.this.modCount;
        }

        public int nextIndex() {
            return currentIndex + 1;
        }

        public int previousIndex() {
            return currentIndex - 1;
        }

        public boolean hasPrevious() {
            return currentIndex - 1 >= 0;
        }

        public E previous() {
            if (currentIndex <= 0) {
                throw new NoSuchElementException("не существует такого элемента");
            }
            if (currentModCount != MyArrayList.this.modCount) {
                throw new ConcurrentModificationException("изменение коллекции во время обхода");
            }
            --currentIndex;
            return items[currentIndex];
        }

        public void set(E e) {
            MyArrayList.this.set(currentIndex, e);
        }

        public void add(E e) {
            MyArrayList.this.add(currentIndex + 1, e);
            currentModCount = MyArrayList.this.modCount;
        }

        public void remove() {
            MyArrayList.this.remove(currentIndex);
            currentModCount = MyArrayList.this.modCount;
        }

        public E next() {
            if (currentIndex >= MyArrayList.this.size()) {
                throw new NoSuchElementException("нет такого элемента");
            }
            if (currentModCount != MyArrayList.this.modCount) {
                throw new ConcurrentModificationException("изменение коллекции во время обхода");
            }
            ++currentIndex;
            return items[currentIndex];
        }

        public boolean hasNext() {
            return currentIndex + 1 < length;
        }

    }

    public ListIterator<E> listIterator(int index) {
        return new MyListIterator(index);
    }

    public ListIterator<E> listIterator() {
        return new MyListIterator();
    }


    public Iterator<E> iterator() {
        return new MyIterator();
    }

    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if (a == null) {
            throw new NullPointerException("пустой массив");
        }
        if (a.length < size()) {
            return (T[]) Arrays.copyOf(items, size(), a.getClass());
        }
        System.arraycopy(items, 0, a, 0, size());
        if (a.length > size()) {
            a[size()] = null;
        }

        return a;

    }

    public boolean removeAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException("пустая коллекция");
        }
        int tempModCount = modCount;
        for (int i = 0; i < size(); ++i) {
            Object object = get(i);
            if (c.contains(object)) {
                remove(object);
                i--;
            }
        }
        return tempModCount != modCount;
    }

    public boolean retainAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException("передана пустая коллекция");
        }

        int tempModCount = modCount;
        for (int i = 0; i < size(); ++i) {
            Object object = get(i);
            if (!c.contains(object)) {
                remove(object);
                i--;
            }
        }
        return modCount != tempModCount;
    }


    public boolean add(E e) {
        ensureCapacity(length + 1);
        items[length] = e;
        ++length;
        ++modCount;
        return true;
    }

    public E set(int index, E element) {

        if (index >= length || index < 0) {
            throw new IndexOutOfBoundsException("по указанному индексу элемента не существует");
        }

        E oldElement = items[index];
        items[index] = element;
        return oldElement;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) > -1;
    }

    public int size() {
        return length;
    }

    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int indexOf(Object o) {

        for (int i = 0; i < size(); ++i) {
            if (Objects.equals(o, items[i])) {
                return i;
            }
        }


        return -1;
    }

    public boolean containsAll(Collection<?> c) {

        if (c == null) {
            throw new NullPointerException("пустая коллекция");
        }

        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }

        }
        return true;

    }

    public boolean addAll(Collection<? extends E> c) {
        if (c == null) {
            throw new NullPointerException("попытка добавить пустую коллекцию");
        }
        Object[] cArray = c.toArray();
        if (cArray.length == 0) {
            return false;
        } else {
            ensureCapacity(size() + cArray.length);
            System.arraycopy(cArray, 0, items, size(), cArray.length);
            length += cArray.length;
            modCount++;
            return true;
        }
    }

    public boolean remove(Object o) {
        int tempModCount = modCount;
        int index = indexOf(o);
        if (index != -1) {
            remove(index);
        }
        return tempModCount != modCount;
    }

    public int lastIndexOf(Object o) {
        int index = -1;
        for (int i = length - 1; i >= 0; --i) {
            if (Objects.equals(items[i], o)) {
                return i;
            }
        }
        return index;
    }

    public void add(int index, E element) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("недопустимый индекс");
        }
        ++modCount;
        ensureCapacity(length + 1);
        System.arraycopy(items, index, items, index + 1, length - index);
        ++length;
        items[index] = element;

    }

    public E remove(int index) {

        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("выход за границы диапазона");
        }

        E oldElement = items[index];
        if (index < length) {
            System.arraycopy(items, index + 1, items, index, length - index - 1);
        }
        ++modCount;
        --length;
        return oldElement;
    }

    @SuppressWarnings("unchecked")
    public void ensureCapacity(int minCapacity) {
        if (minCapacity > size()) {
            items = Arrays.copyOf(items, minCapacity);
        }

    }

    public void trimToSize() {
        int itemsLength = items.length;
        if (itemsLength > size()) {
            items = Arrays.copyOf(items, size());
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size(); ++i) {
            E object = get(i);
            String sbString = object == null ? "null" : object.toString();
            sb.append(sbString);
            sb.append(", ");
        }
        sb.delete(sb.length() - 2, sb.length() - 1);
        sb.append("]");
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

        MyArrayList<?> myArrayList = (MyArrayList<?>) o;
        if (size() != myArrayList.size()) {
            return false;
        } else {
            for (int i = 0; i < size(); ++i) {
                if (!Objects.equals(items[i], myArrayList.items[i])) {
                    return false;
                }
            }
        }
        return true;

    }

    @Override
    public int hashCode() {
        final int prime = 27;
        int hash = 1;
        hash = prime * hash + length;

        int hash2 = 0;
        for (int i = 0; i < size(); ++i) {
            E object = get(i);
            int sum = object == null ? 0 : object.hashCode();
            hash2 += sum;
        }
        hash = prime * hash + hash2;
        return hash;
    }


}

