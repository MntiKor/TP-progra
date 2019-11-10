package com.univamu.arrayList;

import java.util.Iterator;

public class ArrayIterator<E> implements Iterator<E> {
    MyArrayList<E> myArrayList;
    int position = -1;

    public ArrayIterator(MyArrayList<E> myArrayList) {
        this.myArrayList = myArrayList;
    }

    @Override
    public boolean hasNext() {
        return position < myArrayList.size() - 1;
    }

    @Override
    public E next() {
        position++;
        return myArrayList.get(position);
    }
}
