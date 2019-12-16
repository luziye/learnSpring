package com.luziye.bootluanch.CircleSingleLinkedList;

public class testdemo {
    public static void main(String[] args) {
        CircleSingleLinkedList<String> c=new CircleSingleLinkedList<>();
        c.addHead("c");
        c.addHead("b");
        c.addHead("a");
        c.addEnd("x");
        c.addEnd("y");
        c.addEnd("z");
//        c.add("luziye",4);
//        c.deleteHead();
//        c.deleteHead();
//        c.deleteHead();
        System.out.println(c.get(5).data.toString());
        System.out.println("------");
        System.out.println(c.delete(0).data.toString());
        System.out.println("------");
        c.display();
    }
}
