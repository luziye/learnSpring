package com.luziye.bootluanch.DoubleLinkedList;

public class Node<T> {
    public Node<T> pre;
    public T data;
    public Node<T> next;
    public Node(T data){
        this.pre=null;
        this.next=null;
        this.data=data;
    }
    public void display(){
        System.out.println(this.data.toString());
    }
}
