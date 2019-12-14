package com.luziye.bootluanch.CircleSingleLinkedList;

public class CircleSingleLinkedList<T> implements CircleSingleLinkedListInterface<T> {
    public Node<T> start;
    public Node<T> end;
    public int length;

    public CircleSingleLinkedList() {
        this.length = 0;
        this.start = null;
        this.end = null;
    }

    @Override
    public Node addHead(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()){
            this.start = newNode;
            this.end = newNode;
            this.end.next = this.start;
        }
        newNode.next=this.start;
        this.end.next=newNode;
        this.start=newNode;
        this.length++;
        return newNode;
    }

    @Override
    public Node addEnd(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()){
            this.start = newNode;
            this.end = newNode;
            this.end.next = this.start;
        }
        this.end.next=newNode;
        newNode.next=this.start;
        this.end=newNode;
        this.length++;
        return newNode;
    }

    @Override
    public Node add(T data, int position) {
        if (position==0){
            return addHead(data);
        }
        if (position==this.length){
            return addEnd(data);
        }
        if (position<0||position>this.length){
            throw new IndexOutOfBoundsException("越界");
        }
        Node<T> newNode=new Node<>(data);
        Node<T> current=this.start;
        for (int i=1;i<this.length;i++){
            if (i==position){
                Node<T> nextNode=current.next;
                current.next=newNode;
                newNode.next=nextNode;
                this.length++;
                break;
            }
            current=current.next;
        }
        return newNode;
    }

    @Override
    public Node deleteHead() {
        if (isEmpty()){
            throw new RuntimeException("链表为空");
        }
        if (this.length==1){
            Node<T> tmp=this.start;
            this.start=null;
            this.end=null;
            this.length--;
            return tmp;
        }
        Node<T> current=this.start;
        Node<T> nextNode=current.next;
        this.end.next=nextNode;
        this.start=nextNode;
        this.length--;
        return current;
    }

    @Override
    public Node deleteEnd() {
        if (isEmpty()){
            throw new RuntimeException("链表为空");
        }
        if (this.length==1){
            Node<T> tmp=this.end;
            this.start=null;
            this.end=null;
            this.length--;
            return tmp;
        }
//        Node<T> current=this.start;
//        Node<T> nextNode=current.next;
//        while (nextNode!=this.end){
//            current=current.next;
//            nextNode=nextNode.next;
//        }
//        nextNode.next=null;
//        current.next=this.start;
//        this.end=current;
//        this.length--;
//        return nextNode;
        Node<T> current=this.start;
        Node<T> endNode=this.end;
        for (int i=1;i<this.length-1;i++){
            current=current.next;
        }
        current.next=this.start;
        this.end=current;
        this.length--;
        return endNode;
    }

    @Override
    public Node delete(int position) {
        return null;
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
    public Node get(int position) {
        if (isEmpty()){
            throw new RuntimeException("链表为空");
        }
        if (position<0||position>=this.length){
            throw new IndexOutOfBoundsException("越界了");
        }
        if (position==0){
            return getHead();
        }
        Node<T> current=this.start;
        for(int i=1;i<this.length;i++){
            if (i==position){
                return current.next;
            }
            current=current.next;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override
    public int size() {
        return this.length;
    }

    @Override
    public void display(){
        if (this.length == 0) {
            System.out.println("没有数据");
        }
        Node<T> currentnode = this.start;
        for (int i = 0; i < this.length; i++) {
            System.out.println(currentnode.data.toString());
            currentnode = currentnode.next;
        }
    }
}
