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
        for (int i = length - 1; i >= 0; --i) {
            remove(i);
        }
        modCount++;
    }

    public Object[] toArray() {
        Object[] objects = new Object[length];
        System.arraycopy(items, 0, objects, 0, length);
        return objects;
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
        if (index >= length || index < 0) {
            throw new IllegalArgumentException("недопустимый индекс");

        }
        Object[] objects = this.toArray();
        for (E o : c) {
            add(index, o);
            ++index;
        }
        modCount = Arrays.equals(items, objects) ? modCount : modCount + 1;
        return !Arrays.equals(items, objects);
    }

    private class MyIterator implements Iterator<E> {
        private int currentIndex = -1;
        private int currentModCount;

        public MyIterator() {
            currentModCount = MyArrayList.this.modCount;
        }

        public void remove() {
            MyArrayList.this.remove(currentIndex);
        }

        public E next() {
            ++currentIndex;
            if (currentIndex > size()) {
                throw new NoSuchElementException("не существует такого элемента");
            }
           /* if (currentModCount != MyArrayList.this.modCount) {
                throw new ConcurrentModificationException("изменение коллекции за время обхода");
            }*/
            return items[currentIndex];
        }

        public boolean hasNext() {
            return currentIndex + 1 < length;
        }
    }

    private class MyListIterator implements ListIterator<E> {
        private int currentIndex;
        private int currentModCount;

        private MyListIterator() {
            currentIndex = -1;
            currentModCount = MyArrayList.this.modCount;
        }

        private MyListIterator(int index) {
            currentIndex = index;
            currentModCount = MyArrayList.this.modCount;
        }

        public int nextIndex() {
            return ++currentIndex;
        }

        public int previousIndex() {
            return --currentIndex;
        }

        public boolean hasPrevious() {
            return previousIndex() >= 0;
        }

        public E previous() {
            --currentIndex;
            if (currentIndex < 0) {
                throw new NoSuchElementException("не существует такого элемента");
            }
           /* if (currentModCount != MyArrayList.this.modCount) {
                throw new ConcurrentModificationException("изменение коллекции во время обхода");
            }*/
            return items[currentIndex];
        }

        public void set(E e) {
            MyArrayList.this.set(currentIndex, e);
        }

        public void add(E e) {
            MyArrayList.this.add(currentIndex + 1, e);
        }

        public void remove() {
            MyArrayList.this.remove(currentIndex);
        }

        public E next() {
            ++currentIndex;
            if (currentIndex > MyArrayList.this.size()) {
                throw new NoSuchElementException("нет такого элемента");
            }
            /*if (currentModCount != MyArrayList.this.modCount) {
                throw new ConcurrentModificationException("изменение коллекции во время обхода");
            }*/
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

        a = (T[]) Arrays.copyOf(items, a.length, a.getClass());
        return a;

    }

    public boolean removeAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException("пустая коллекция");
        }

        Object[] old = this.toArray();
        Iterator iterator = c.iterator();
        while (iterator.hasNext()) {
            remove(iterator.next());
        }

        modCount = Arrays.equals(old, items) ? modCount : modCount + 1;
        return !Arrays.equals(old, items);
    }

    public boolean retainAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException("передана пустая коллекция");
        }
        Object[] old = this.toArray();
        Iterator iterator = iterator();

        while (iterator.hasNext()) {
            Object value = iterator.next();
            if (!c.contains(value)) {
                remove(value);
            }
        }
        modCount = Arrays.equals(items, old) ? modCount : modCount + 1;
        return !Arrays.equals(items, old);
    }


    public boolean add(E e) {
        if (length >= items.length) {
            ensureCapacity(length + 1);
        }
        items[length] = e;
        ++length;
        ++modCount;
        return true;
    }

    public E set(int index, E element) {

        if (index >= length) {
            throw new IndexOutOfBoundsException("по указанному индекса элемента не существует");
        }
        ++modCount;
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
        int counter = 0;
        for (E object : items) {
            if (Objects.equals(object, o)) {
                return counter;
            }
            ++counter;
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
        Object[] oldList = this.toArray();
        for (E o : c) {
            add(o);
        }
        if (!Arrays.equals(oldList, items)) {
            ++modCount;
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(Object o) {
        ++modCount;
        if (indexOf(o) != -1) {
            remove(indexOf(o));
            return true;
        }
        return false;
    }

    public int lastIndexOf(Object o) {
        int index = -1;
        for (int i = 0; i < length; ++i) {
            if (items[i].equals(o)) {
                index = i;
            }
        }
        return index;
    }

    public void add(int index, E element) {
        ++modCount;
        if (length >= items.length) {
            ensureCapacity(length + 1);
        }
        ++length;
        System.arraycopy(items, index, items, index + 1, length - index + 1);
        items[index] = element;

    }

    public E remove(int index) {
        ++modCount;
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("выход за границы диапазона");
        }
        E oldElement = items[index];
        if (index < length - 1) {
            System.arraycopy(items, index + 1, items, index, length - index - 1);
        }
        --length;
        return oldElement;
    }

    @SuppressWarnings("unchecked")
    public void ensureCapacity(int minCapacity) {
        E[] old = items;
        items = (E[]) new Object[minCapacity];
        items = Arrays.copyOf(old, minCapacity);
    }

    public void trimToSize() {
        ++modCount;
        items = Arrays.copyOf(items, length);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (E object : items) {
            String sbString = object == null ? "null" : object.toString();
            sb.append(sbString);
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

        MyArrayList<?> myArrayList = (MyArrayList<?>) o;
        if (size() != myArrayList.size()) {
            return false;
        } else {
            for (int i = 0; i < size(); ++i) {
                if (!Objects.equals(items[i], ((MyArrayList<?>) o).items[i])) {
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
        hash = prime * hash + modCount;
        hash = prime * hash + Arrays.hashCode(items);
        return hash;
    }


}
