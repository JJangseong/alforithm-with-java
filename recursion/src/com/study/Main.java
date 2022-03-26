package com.study;

import com.study.linked.Editor;
import com.study.linked.Lineup;

/**
 * Created by marathoner on 2021/12/03
 */
public class Main {
    public static void main(String[] args) {
        Lineup lineup = new Lineup();
        lineup.run(5, "0 1 1 3 2");
        System.out.println();
        Editor e = new Editor();
        e.run("abc", 9, "L", "L", "L", "L", "L", "P x", "L", "B", "P y");
    }
}
