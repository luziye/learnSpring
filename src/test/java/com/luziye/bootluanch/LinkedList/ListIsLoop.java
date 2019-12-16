package com.luziye.bootluanch.LinkedList;

import java.util.Set;

public class ListIsLoop {
    public static void main(String[] args) {
        SingleLinkedList<Integer> s=new SingleLinkedList<>();
        s.insert(2);
        s.insert(4);
        s.insert(6);
        s.insert(8);
        s.insert(9);
        s.insert(10);
        s.display();
        System.out.println(isLoop(s));


    }
    public static boolean isLoop(SingleLinkedList<Integer> s){
        Node quick=s.getStart();
        Node slow=s.getStart();
        while (quick!=null&&quick.next!=null){
            quick=quick.next.next;
            slow=slow.next;
            if (quick==slow){
                return true;
            }
        }
        return false;
    }
}
