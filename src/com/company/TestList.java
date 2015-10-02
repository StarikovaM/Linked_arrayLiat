package com.company;
import java.util.*;
public class TestList {
    private static final int NUM_ELEMENTS = 100 * 1000;
    public static void main(String[] args) {
        List ar = new ArrayList();
        for (int i = 0; i < NUM_ELEMENTS; i++) {
            ar.add(i);
        }
        testBegin(ar);
        testBegin(new LinkedList(ar));
        testMiddle(ar);
        testMiddle(new LinkedList(ar));
        testEnd(ar);
        testEnd(new LinkedList(ar));
    }
    public static void testBegin(List list) {
        long time = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            list.add(0, new Object());
            list.remove(0);
        }
        time = System.currentTimeMillis() - time;
        System.out.println("beginning " +
                list.getClass().getSimpleName() + " time: " + time);
    }
    public static void testMiddle(List list) {
        long time = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            list.add(NUM_ELEMENTS / 2, new Object());
            list.remove(NUM_ELEMENTS / 2);
        }
        time = System.currentTimeMillis() - time;
        System.out.println("middle    " +
                list.getClass().getSimpleName() + " time: " + time);
    }
    public static void testEnd(List list) {
        long time = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            list.add(new Object());
            list.remove(NUM_ELEMENTS);
        }
        time = System.currentTimeMillis() - time;
        System.out.println("end       " +
                list.getClass().getSimpleName() + " time: " + time);
    }


}
