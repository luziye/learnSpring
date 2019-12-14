package com.luziye.bootluanch.Stack;

public interface LuStack<T> {
    void add(T t);
    T remove();
    int size();
    boolean isEmpty();
    boolean isFull();
    T get(int index);
}
