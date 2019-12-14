package com.luziye.bootluanch.LinkedList;

import com.luziye.bootluanch.LinkedList.SingleLinkedList;

public class testDemo {
    public static void main(String[] args) {
        SingleLinkedList<String> stringSingleLinkedList = new SingleLinkedList<>();
        stringSingleLinkedList.insert("a");
        stringSingleLinkedList.insert("b");
        stringSingleLinkedList.insert("c");
        stringSingleLinkedList.insert("d");
        System.out.println("-----------");
//        stringSingleLinkedList.insertHead("head");
//        System.out.println("-----------");
//        stringSingleLinkedList.insert("aka", 2);
//        stringSingleLinkedList.display();
//        System.out.println("-----------");
//        Node<String> node= stringSingleLinkedList.deleteEnd();
//        System.out.println(node.data.toString());
//        stringSingleLinkedList.display();
        System.out.println("-----------");
        Node de=stringSingleLinkedList.delete(3);
        System.out.println("deleted node is:"+de.data.toString());
        stringSingleLinkedList.display();


    }
}
