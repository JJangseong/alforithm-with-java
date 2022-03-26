package com.study.linked;

import java.util.LinkedList;

/**
 * Created by marathoner on 2022/03/26
 */
public class Lineup {
    public void run(int max, String str) {
        String[] strs = str.split(" ");
        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        for(int i=1; i<strs.length; i++) {
           int num = Integer.parseInt(strs[i]);
            list.add(num, i+1);
        }
        for(int i=list.size()-1; i>=0; i--) {
            System.out.print(list.get(i) + " ");
        }
    }

}
