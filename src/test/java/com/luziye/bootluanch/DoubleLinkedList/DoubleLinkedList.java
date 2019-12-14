package com.luziye.bootluanch.DoubleLinkedList;

public class DoubleLinkedList<T> implements DoubleLinkedListInterface<T> {
    private int length;
    private Node<T> start;
    private Node<T> end;

    public DoubleLinkedList() {
        this.start = null;
        this.end = null;
        this.length = 0;
    }

    @Override
    public Node addHead(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            this.start = newNode;
            this.end = newNode;
        } else {
            newNode.next = this.start;
            this.start.pre = newNode;
            this.start = newNode;
        }
        this.length++;
        return newNode;

    }

    @Override
    public Node addEnd(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            this.start = newNode;
            this.end = newNode;
        } else {
            newNode.pre = this.end;
            this.end.next = newNode;
            this.end = newNode;
        }
        this.length++;
        return newNode;
    }

    @Override
    public Node add(T data, int position) {
        if (position > this.length || position < 0) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        if (position == 0) {
            addHead(data);
        }
        if (position == this.length) {
            addEnd(data);
        }
        Node<T> newNode = new Node<>(data);
        Node<T> current = this.start;
        for (int i = 1; i < this.length - 1; i++) {
            if (i == position) {
                Node<T> currentNext = current.next;
                current.next = newNode;
                newNode.pre = current;
                newNode.next = currentNext;
                currentNext.pre = newNode;
                this.length++;
                break;
            }
            current = current.next;
        }
        return newNode;
    }

    @Override
    public Node deleteHead() {
        if (isEmpty()) {
            throw new RuntimeException("链表空");
        }
        Node<T> deleteNode = this.start;
        if (this.length == 1) {
            this.start = null;
            this.end = null;
        } else {
            this.start = this.start.next;
            this.start.pre = null;
        }
        this.length--;
        return deleteNode;
    }

    @Override
    public Node deleteEnd() {
        if (isEmpty()) {
            throw new RuntimeException("链表空");
        }
        Node<T> deleteNode = this.end;
        if (this.length == 1) {
            this.start = null;
            this.end = null;
        } else {
            this.end = this.end.pre;
            this.end.next = null;
        }
        this.length--;
        return deleteNode;
    }

    @Override
    public Node delete(int position) {
        if (isEmpty()) {
            throw new RuntimeException("链表空");
        }
        if (position > this.length - 1 || position < 0) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        if (position == 0) {
            return deleteHead();
        }
        if (position == this.length) {
            return deleteEnd();
        }
        Node<T> deleteNode = null;
        Node<T> current=this.start;
        for (int i = 1; i < this.length - 1; i++) {
            if (position == i) {
                deleteNode=current.next;
                current.next=deleteNode.next;
                deleteNode.next.pre=current;
                break;
            }
            current=current.next;
        }
        this.length--;
        return deleteNode;
    }

    @Override
    public Node getHead() {
        return this.start;
    }

    @Override
    public Node getEnd() {
        return this.end;
    }

    @Override
    public void display() {
        if (isEmpty()) {
            throw new RuntimeException("链表空");
        } else {
            Node<T> current = this.start;
            for (int i = 0; i < this.length; i++) {
                System.out.println(current.data.toString());
                current = current.next;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override
    public int size() {
        return this.length;
    }
}
