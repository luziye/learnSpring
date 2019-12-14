package com.luziye.bootluanch.Queue;

public interface QueueInterface<T> {
    void add(T t);
    T remove();
    int size();
    T front();
    T last();
    T get(int index);
    boolean isEmpty();
    boolean isFull();
}
