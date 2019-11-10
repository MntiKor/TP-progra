package com.univamu.arrayList;

import java.util.*;

import static java.lang.Integer.max;

public class MyArrayList<T> implements List<T> {

    private int size;
    private T[] table;

    public MyArrayList(int len) {
        this.table = (T[]) new Object[len];
        this.size = 0;
    }

    public MyArrayList() {
        this(10);
    }

    public MyArrayList(Collection<T> coll) {
        this(coll.size());
        for (T i : coll) {
            this.add(i);
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object o) {
        int i = 0;
        while (i < size)
        {
            if (table[i] == o)
                return true;
            i++;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int position = -1;
            @Override
            public boolean hasNext() {
                return position<size-1;
            }

            @Override
            public T next() {
                position++;
                return get(position);
            }
        };
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        ensureCapacity(size + 1);
        table[size] = t;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (indexOf(o) == -1)
            return false;
        else
        {
            remove(indexOf(o));
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        /* ajouter ensureCapacity */
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        /* ajouter ensureCapacity */
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return this.table[index];
    }

    @Override
    public T set(int index, T element) {
        T preelt = table[index];
        table[index] = element;
        return preelt;
    }

    @Override
    public void add(int index, T element) {
        ensureCapacity(max(size+1, index + 1));
        if (index>=size) {
            table[index] = element;
            size = index  + 1;
        }
        else
        {
            int i = size - 1;
            while (i >= index)
            {
                table[i+1] = table[i];
                i--;
            }
            table[index] = element;
            size++;
        }
    }

    @Override
    public T remove(int index) {
        T ret = table[index];
        int i = index;
        while (i < size - 1)
        {
            table[i] = table[i+1];
            i++;
        }
        size--;
        return ret;
    }

    @Override
    public int indexOf(Object o) {
        int i = 0;
        while (i < size)
        {
            if (table[i] == o)
                return i;
            i++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int i = size - 1;
        while (i > -1)
        {
            if (table[i] == o)
                return i;
            i--;
        }
        return -1;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(size).append("[");
        int i = 0;
        while ( i < size)
        {
            sb.append(table[i].toString());
            if (i < size-1) sb.append(", ");
            i++;
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof List<?>)) {
            return false;
        }
        List<?> other = (List<?>) obj;
        int i = 0;
        while (i < table.length)
        {
            if (table[i] != other.get(i))
                return false;
            i++;
        }
        return true;
    }

    public void ensureCapacity(int capacity)
    {
        if (table.length < capacity)
        {
            T[] newtable = (T[]) new Object[capacity * 2];
            int i = 0;
            while (i < table.length)
            {
                newtable[i] = table[i];
                i++;
            }
            table = newtable;
        }
    }
}
