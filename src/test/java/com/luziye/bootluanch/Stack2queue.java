package com.luziye.bootluanch;

import java.util.Stack;

public class Stack2queue {
    Stack<String> s1 = new Stack<>();
    Stack<String> s2 = new Stack<>();

    public void addData(String[] s) {
        for (String string : s) {
            s1.push(string);
        }
    }

    public String push2pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    public static void main(String[] args) {
        Stack2queue s2q=new Stack2queue();
        s2q.addData(new String[]{"a", "b", "c", "d"});
        System.out.println(s2q.push2pop());
        System.out.println(s2q.push2pop());
        System.out.println(s2q.push2pop());
        System.out.println(s2q.push2pop());
    }
}
