package com.luziye.bootluanch;

import java.util.Arrays;
import java.util.Stack;

public class test {
    public static void main(String[] args) {
        Stack2queue.addData(new String[]{"a", "b", "c", "d"});
        System.out.println(Stack2queue.push2pop());
        System.out.println(Stack2queue.push2pop());
        System.out.println(Stack2queue.push2pop());
        System.out.println(Stack2queue.push2pop());

    }

    static class Stack2queue {
        static Stack<String> s1 = new Stack<>();
        static Stack<String> s2 = new Stack<>();

        public static void addData(String[] s) {
            for (String string : s) {
                s1.push(string);
            }
        }

        public static String push2pop() {
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.pop();
        }
    }
}
