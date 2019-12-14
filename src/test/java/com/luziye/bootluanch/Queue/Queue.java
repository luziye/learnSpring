package com.luziye.bootluanch.Queue;

public class Queue<T> implements QueueInterface<T> {
    private T[] data;
    private int size;
    private int front;
    private int at;

    Queue() {
        this.data = (T[]) new Object[10];
        this.size = 0;
        this.front = 0;
        this.at = 0;
    }

    @Override
    public void add(T t) {
        if (isFull()) {
            resize();
        }
        data[this.at] = t;
        this.at++;
        this.size++;
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        T temp = this.data[this.front];
        if (this.size == 1) {
            this.at = 0;
            this.size = 0;
            this.data = (T[]) new Object[10];
            return temp;
        }
        T[] tmp = (T[]) new Object[this.data.length];
        System.arraycopy(this.data, 1, tmp, 0, this.size - 1);
        this.data = tmp;
        tmp = null;
        this.size--;
        return temp;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public T front() {
        if (isEmpty()) {
            throw new RuntimeException("队列空");
        }
        return this.data[this.front];
    }

    @Override
    public T last() {
        if (isEmpty()) {
            throw new RuntimeException("队列空");
        }
        return this.data[this.size - 1];
    }

    @Override
    public T get(int index) {
        if (isEmpty()) {
            throw new RuntimeException("队列空");
        }
        if (index < 0) {
            throw new RuntimeException("无效索引");
        }
        if (index >= size) {
            throw new RuntimeException("索引越界");
        }
        return this.data[index];
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean isFull() {
        return this.size == this.data.length;
    }

    public void resize() {
        T[] tmp = (T[]) new Object[this.data.length * 2];
        System.arraycopy(this.data, 0, tmp, 0, data.length);
        data = tmp;
        tmp = null;
    }

    public static void main(String[] args) {
        Queue<String> q1=new Queue<>();
        q1.add("a");
        q1.add("b");
        q1.add("c");
        q1.add("d");
        q1.add("e");
        System.out.println(q1.get(2));
        System.out.println(q1.size);
        System.out.println(q1.remove());
        System.out.println(q1.get(0));

    }
}
