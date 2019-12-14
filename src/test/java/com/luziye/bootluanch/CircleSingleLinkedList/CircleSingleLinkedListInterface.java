package com.luziye.bootluanch.CircleSingleLinkedList;

public interface CircleSingleLinkedListInterface<T> {
    Node addHead(T data);
    Node addEnd(T data);
    Node add(T data,int position);
    Node deleteHead();
    Node deleteEnd();
    Node delete(int position);
    Node getHead();
    Node getEnd();
    Node get(int position);
    boolean isEmpty();
    int size();
    void display();


}
