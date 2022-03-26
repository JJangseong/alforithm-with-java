package com.study.linked;

import java.util.LinkedList;

/**
 * Created by marathoner on 2022/03/26
 */
public class Editor {
    public void run(String str, int size, String... commands) {
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            list.add(str.split("")[i]);
        }

        int c = str.length();

        for (int i = 0; i < size; i++) {
            String command = commands[i];
            String[] commandSplit = command.split(" ");

            switch (commandSplit[0]) {
                case "L":
                    if (c > 0) {
                        c -= 1;
                    }
                    break;
                case "D":
                    if (str.length() > c) {
                        c += 1;
                    }
                    break;
                case "B":
                    if(c > 0 && c <= str.length()) {
                        // 지우기
                        list.remove(c-1);
                    }
                    break;
                case "P":
                    list.add(c, commandSplit[1]);
                    c+=1;
                    break;
            }
        }

        for(String s : list) {
            System.out.print(s + " ");
        }
    }
}
