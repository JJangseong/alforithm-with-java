package com.recursion;

import com.recursion.array.LinkedList;

import java.util.*;

/**
 * Created by marathoner on 2021/12/03
 */
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(7);
        list.add(6);
        list.add(5);
        System.out.println(list.getSize());
        list.print();
        list.remove(2);
        list.remove(2);
        list.remove(2);
        list.remove(2);
        list.remove(2);
        list.remove(1);
        list.remove(0);
        System.out.println(list.getSize());
        list.print();
    }
}
