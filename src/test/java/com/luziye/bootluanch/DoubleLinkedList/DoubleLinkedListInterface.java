package com.luziye.bootluanch.DoubleLinkedList;

public interface DoubleLinkedListInterface<T> {
    Node addHead(T data);
    Node addEnd(T data);
    Node add(T data,int position);
    Node deleteHead();
    Node deleteEnd();
    Node delete(int position);
    Node getHead();
    Node getEnd();
    void display();
    boolean isEmpty();
    int size();
}
