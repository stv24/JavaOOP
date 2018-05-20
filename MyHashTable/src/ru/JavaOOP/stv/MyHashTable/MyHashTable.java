package ru.JavaOOP.stv.MyHashTable;

import java.util.*;

public class MyHashTable<T> implements Collection<T> {
    private ArrayList<T>[] arrayLists;
    private int modCount = 0;
    private int elementsCount;
    private double loadFactor;

    @SuppressWarnings("unchecked")
    public MyHashTable(int arrayListsCount) {
        if (arrayListsCount <= 0) {
            throw new IllegalArgumentException(" MyHashTable: неверное значение аргумента");
        }
        arrayLists = new ArrayList[arrayListsCount];
        elementsCount = 0;
        loadFactor = 0.7;
    }

    @SuppressWarnings("unchecked")
    public <E> E[] toArray(E[] a) {
        if (a == null) {
            throw new NullPointerException("toArray: передан пустой массив");
        }
        if (a.length < elementsCount) {
            a = (E[]) new Object[elementsCount];
        }
        int index = 0;
        for (T e : this) {
            a[index] = (E) e;
            index++;
        }
        return a;
    }

    public void clear() {
        elementsCount = 0;
    }

    public Object[] toArray() {
        Object[] a = new Object[this.size()];
        int index = 0;
        for (T e : this) {
            a[index] = e;
            index++;
        }
        return a;
    }

    @SuppressWarnings("unchecked")
    public boolean add(T e) {
        int index = Math.abs(e.hashCode() % arrayLists.length);

        if (arrayLists[index] == null) {
            arrayLists[index] = new ArrayList<>();
        }
        arrayLists[index].add(e);
        ++elementsCount;
        ++modCount;

        if ((double) elementsCount / arrayLists.length > loadFactor) {
            ArrayList<T> collection = new ArrayList(Arrays.asList(this.toArray()));
            arrayLists = new ArrayList[arrayLists.length * 2];
            addAll(collection);
        }
        return true;
    }


    public boolean addAll(Collection<? extends T> c) {
        int oldModCount = modCount;
        if (c == null) {
            throw new NullPointerException("addAll: передана пустая коллекция");
        }
        for (T object : c) {
            add(object);
        }
        return oldModCount != modCount;
    }

    public boolean contains(Object o) {
        int index = Math.abs(o.hashCode() % arrayLists.length);
        if (arrayLists[index] == null) {
            return false;
        }
        ArrayList<T> list = arrayLists[index];
        return list.contains(o);
    }

    public boolean containsAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException("ContainsAll: передана пустая коллекция");
        }
        for (Object object : c) {
            if (!contains(object)) {
                return false;
            }
        }

        return true;
    }

    public boolean isEmpty() {
        return elementsCount == 0;
    }

    private class HashTableIterator implements Iterator<T> {
        private int currentIndex = 0;
        private int innerIndex = -1;
        private int elementsCount = 0;
        private int elementsNumber = MyHashTable.this.size();
        private int modCountCurrent;

        private HashTableIterator() {
            modCountCurrent = MyHashTable.this.modCount;
        }

        public void remove() {
            MyHashTable.this.remove(arrayLists[currentIndex].get(innerIndex));
            innerIndex--;
            modCountCurrent = MyHashTable.this.modCount;
        }

        public T next() {
            if (modCountCurrent != MyHashTable.this.modCount) {
                throw new ConcurrentModificationException("изменение коллекции за время обхода");
            }
            if (arrayLists[currentIndex] != null) {
                if (innerIndex < arrayLists[currentIndex].size() - 1) {
                    ++innerIndex;
                    ++elementsCount;
                    return arrayLists[currentIndex].get(innerIndex);
                }
                ++currentIndex;
            }
            while (arrayLists[currentIndex] == null) {
                ++currentIndex;
            }
            innerIndex = 0;
            ++elementsCount;
            return arrayLists[currentIndex].get(innerIndex);
        }

        public boolean hasNext() {
            return elementsCount < elementsNumber;
        }

    }

    public Iterator<T> iterator() {
        return new HashTableIterator();
    }

    public boolean remove(Object o) {
        int index = Math.abs(o.hashCode() % arrayLists.length);
        if (arrayLists[index] == null) {
            return false;
        }
        int oldModCount = modCount;
        modCount = arrayLists[index].remove(o) ? modCount + 1 : modCount;
        return oldModCount != modCount;
    }

    public boolean removeAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException("RemoveAll: передана пустая коллекция");
        }
        int oldModCount = modCount;
        for (ArrayList<T> list : arrayLists) {
            if (list == null) {
                continue;
            }
            list.removeAll(c);
        }
        return oldModCount != modCount;
    }

    public boolean retainAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException("retainAll: передана пустая коллекция");
        }
        int oldModCount = modCount;
        for (ArrayList<T> list : arrayLists) {
            if (list == null) {
                continue;
            }
            list.retainAll(c);
        }
        return oldModCount != modCount;
    }

    public int size() {
        return elementsCount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (ArrayList<T> list : arrayLists) {
            String str = list == null ? "null" : list.toString();
            sb.append(str);
            sb.append(", ");
        }
        sb.delete(sb.length() - 2, sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        MyHashTable<T> object = (MyHashTable<T>) o;

        if (this.arrayLists.length != object.arrayLists.length) {
            return false;
        }

        for (int i = 0; i < this.arrayLists.length; ++i) {
            if (!Objects.equals(object.arrayLists[i], arrayLists[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 12;
        final int prime = 11;
        hash = prime * hash + elementsCount;
        int hashSum = 0;
        for (ArrayList<T> list : arrayLists) {
            int tempSum = list == null ? 0 : list.hashCode();
            hashSum += tempSum;
        }
        hash = prime * hash + hashSum;
        return hash;
    }

}
