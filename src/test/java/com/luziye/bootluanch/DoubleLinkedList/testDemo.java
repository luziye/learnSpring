package com.luziye.bootluanch.DoubleLinkedList;

public class testDemo {
    public static void main(String[] args) {
        DoubleLinkedList<String> doubleLinkedList=new DoubleLinkedList<>();
        doubleLinkedList.addHead("aa");
        doubleLinkedList.addEnd("bb");
        doubleLinkedList.addEnd("cc");
        doubleLinkedList.addEnd("dd");
        doubleLinkedList.display();
        System.out.println("-------");
//        doubleLinkedList.add("vv",2);
//        doubleLinkedList.add("mm",0);
//        doubleLinkedList.add("tt",doubleLinkedList.size());
//        doubleLinkedList.display();
//        Node de=doubleLinkedList.deleteHead();
//        System.out.println("deleted head node is:"+de.data.toString());
//        Node de2=doubleLinkedList.deleteHead();
//        System.out.println("deleted head node is:"+de2.data.toString());
//        doubleLinkedList.display();
//        System.out.println("-------");
//        Node de=doubleLinkedList.deleteEnd();
//        System.out.println("deleted end node is:"+de.data.toString());
//        doubleLinkedList.display();
//        System.out.println("-------");
        Node de=doubleLinkedList.delete(0);
        System.out.println("deleted node is:"+de.data.toString());
        doubleLinkedList.display();

    }

}
