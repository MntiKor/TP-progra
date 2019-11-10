package com.univamu.arrayList;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;


import static org.junit.Assert.*;

public class MyArrayListTest {

  MyArrayList<Integer> emptyMAL = new MyArrayList<>();
  ArrayList<Integer> emptyAL = new ArrayList<>();
  MyArrayList<Integer> someMAL = generateMAL(10);
  ArrayList<Integer> someAL = generateAL(10);

  private static MyArrayList<Integer> generateMAL(int size) {
    MyArrayList<Integer> someMAL = new MyArrayList<>(size * 2);
    for (int index = 0; index < size; index++) {
      someMAL.add(index);
    }
    return someMAL;
  }

  private static ArrayList<Integer> generateAL(int size) {
    ArrayList<Integer> someAL = new ArrayList<>(size * 2);
    for (int index = 0; index < size; index++) {
      someAL.add(index);
    }
    return someAL;
  }

  @Test
  public void testToString() {
    assertEquals(emptyAL.toString(), emptyMAL.toString());
    assertEquals(someAL.toString(), someMAL.toString());
  }

  @Test
  public void testEquals() {
    assertEquals(emptyAL, emptyMAL);
    assertEquals(someAL, someMAL);
    assertNotEquals(someAL, emptyMAL);
    assertNotEquals(emptyAL, someMAL);
  }

  @Test
  public void size() {
    assertEquals(0, emptyMAL.size());
    assertEquals(10, someMAL.size());
  }

  @Test
  public void testConstructor() {
    assertEquals(emptyAL, new MyArrayList<Integer>(emptyAL));
    assertEquals(emptyAL, new MyArrayList<Integer>(emptyMAL));
    assertEquals(someAL, new MyArrayList<Integer>(someAL));
    assertEquals(someAL, new MyArrayList<Integer>(someMAL));
  }

  @Test
  public void isEmpty() {
    assertTrue(emptyMAL.isEmpty());
    assertFalse(someMAL.isEmpty());
  }

  @Test
  public void add() {
    ArrayList<Integer> al = generateAL(10);
    MyArrayList<Integer> mal = generateMAL(10);
    assertEquals(al.add(11), mal.add(11));
    MyArrayList<Integer> list = new MyArrayList<>();
    list.add(42);
    assertEquals(1, list.size());
  }
  @Test
  public void add2() {
    ArrayList<Integer> al = generateAL(10);
    MyArrayList<Integer> mal = generateMAL(10);
    al.add(2, 11);
    mal.add(2,11);
    assertEquals(al, mal);
    MyArrayList<Integer> list = new MyArrayList<>();
    list.add(0,42);
    assertEquals(1, list.size());
  }

  @Test
  public void get() {
    assertEquals(4, (int) someAL.get(4));
  }

  @Test
  public void set() {
    ArrayList<Integer> copyAL = new ArrayList<>(someAL);
    MyArrayList<Integer> copyMAL = new MyArrayList<>(someMAL);
    copyAL.set(3, 42);
    copyMAL.set(3, 42);
    assertEquals(copyAL, copyMAL);
  }


  @Test
  public void iterator() {
    Iterator<Integer> alIter = someAL.iterator();
    Iterator<Integer> malIter = someMAL.iterator();
    for (int iterCount = 0; alIter.hasNext(); iterCount++) {
      assertTrue(
        "test hasNext iteration " + iterCount,
        malIter.hasNext()
      );
      assertEquals(
        "test next iteration " + iterCount,
        alIter.next(),
        malIter.next()
      );
    }
    assertFalse("test last hasNext", malIter.hasNext());
  }

  @Test
  public void contains() {
    ArrayList<Integer> al = generateAL(10);
    MyArrayList<Integer> mal = generateMAL(10);
    al.set(5, 12);
    mal.set(5, 12);
    assertEquals(al.contains(12), mal.contains(12));
    assertEquals(al.contains(122), mal.contains(122));
  }

  @Test

  public void indexOf() {
    ArrayList<Integer> al = generateAL(10);
    MyArrayList<Integer> mal = generateMAL(10);
    al.set(5, 12);
    mal.set(5, 12);
    al.set(7, 12);
    mal.set(7, 12);
    assertEquals(al.indexOf(12), mal.indexOf(12));
    assertEquals(al.indexOf(122), mal.indexOf(122));
  }

  @Test

  public void lastIndexOf() {
    ArrayList<Integer> al = generateAL(10);
    MyArrayList<Integer> mal = generateMAL(10);
    al.set(5, 12);
    mal.set(5, 12);
    al.set(7, 12);
    mal.set(7, 12);
    assertEquals(al.lastIndexOf(12), mal.lastIndexOf(12));
    assertEquals(al.lastIndexOf(122), mal.lastIndexOf(122));
  }

  @Test

  public void removeIndex() {
    ArrayList<Integer> al = generateAL(10);
    MyArrayList<Integer> mal = generateMAL(10);
    assertEquals(al.remove(5), mal.remove(5));
    assertEquals(al, mal);
  }

  @Test

  public void removeObject() {
    ArrayList<Boolean> al = new ArrayList<Boolean>(10);
    MyArrayList<Boolean> mal = new MyArrayList<Boolean>(10);
    al.add(true);
    al.add(false);
    mal.add(true);
    mal.add(false);
    assertEquals(al.remove(false), mal.remove(false));
    assertEquals(al, mal);
  }
}