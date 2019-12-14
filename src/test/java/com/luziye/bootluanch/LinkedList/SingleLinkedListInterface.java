package com.luziye.bootluanch.LinkedList;

public interface SingleLinkedListInterface<T> {
      Node<T> insert(T data);
      Node<T> insertHead(T data);
      Node<T> insert(T data,int position);
      Node<T> deleteEnd();
      Node<T> delete(int position);
      Node<T> getStart();
      Node<T> getEnd();
      boolean isEmpty();
      void display();
      int size();
}
