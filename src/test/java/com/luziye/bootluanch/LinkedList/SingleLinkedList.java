package com.luziye.bootluanch.LinkedList;

public class SingleLinkedList<T> implements SingleLinkedListInterface<T> {
    private Node<T> start;
    private Node<T> end;
    private int length;

    public SingleLinkedList() {
        this.start = null;
        this.end = null;
        this.length = 0;
    }

    @Override
    public Node<T> insert(T data) {
        Node<T> newNode = new Node<T>(data);
        if (isEmpty()) {
            this.start = newNode;
            this.end = newNode;
        } else {
            this.end.next = newNode;
            this.end = newNode;
        }
        this.length++;
        return newNode;
    }

    @Override
    public Node<T> insertHead(T data) {
        Node<T> newNode = new Node<T>(data);
        if (isEmpty()) {
            this.start = newNode;
            this.end = newNode;
        } else {
            newNode.next = this.start;
            this.start = newNode;
        }
        this.length++;
        return newNode;
    }

    @Override
    public Node<T> insert(T data, int position) {
        if (position > this.length || position < 0) {
            throw new IndexOutOfBoundsException("越界");
        }
        if (position == 0) {
            insertHead(data);
        }
        if (position == this.length) {
            insert(data);
        }
        Node<T> newNode = new Node<T>(data);
        Node<T> currentNode = this.start;
        for (int i = 1; i < this.length; i++) {
            if (position == i) {
                Node<T> nextNode = currentNode.next;
                currentNode.next = newNode;
                newNode.next = nextNode;
                break;
            }
            currentNode = currentNode.next;
        }
        this.length++;
        return newNode;
    }

    @Override
    public Node<T> deleteEnd() {
        if (isEmpty()) {
            throw new RuntimeException("没有数据，删除失败");
        }
        if (this.length == 1) {
            Node<T> deletenode=this.start;
            this.end = null;
            this.start = null;
            this.length = 0;
            return deletenode;
        }
        Node<T> currentNode = this.start;
        Node<T> tmp=this.end;
        while (currentNode.next != this.end) {
            currentNode = currentNode.next;
        }
        currentNode.next = null;
        this.length--;
        this.end = currentNode;
        return tmp;
    }

    @Override
    public Node<T> delete(int position) {
        if (isEmpty()){
            throw new RuntimeException("没有可以删除的");
        }
        if (position >= this.length || position < 0) {
            throw new IndexOutOfBoundsException("越界");
        }
        if (position == 0) {
            Node<T> tmp=this.start;
            this.start=tmp.next;
            this.length--;
            return tmp;
        }
        if (position == this.length-1) {
            return deleteEnd();
        }
        Node<T> currentNode=this.start;
        Node<T> deleteNode=null;
        for (int i=1;i<this.length-1;i++){
            if (position==i){
                deleteNode=currentNode.next;
                currentNode.next=deleteNode.next;
                break;
            }
            currentNode=currentNode.next;
        }
        this.length--;
        return deleteNode;
    }

    @Override
    public Node<T> getStart() {
        return this.start;
    }

    @Override
    public Node<T> getEnd() {
        return this.end;
    }

    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override
    public void display() {
        if (this.length == 0) {
            System.out.println("没有数据");
        }
        Node<T> currentnode = this.start;
        for (int i = 0; i < this.length; i++) {
            System.out.println(currentnode.data.toString());
            currentnode = currentnode.next;
        }
    }

    @Override
    public int size() {
        return this.length;
    }
}
