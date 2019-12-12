package com.luziye.bootluanch;

public class MyStack<T> implements LuStack<T> {
    private int size;
    private int index;
    private T[] data;
    MyStack(){
        this.size=0;
        this.index=0;
        this.data=(T[])new Object[10];
    }
    @Override
    public void add(T t) {
        if (isFull()){
            resize();
        }
        this.data[this.index]=t;
        size++;
        index++;
    }

    @Override
    public T remove() {
        if (isEmpty()){
            throw new RuntimeException("栈为空");
        }
        T t=this.data[this.index];
        if (this.size==1){
            size--;
            this.data[this.index]=null;
            return t;
        }
        T[] tmp=(T[])new Object[this.data.length];
        System.arraycopy(data,0,tmp,0,data.length-1);
        data=tmp;
        size--;
        index--;
        tmp=null;
        return this.data[this.size];

    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size==0;
    }

    @Override
    public boolean isFull() {
        return this.data.length==this.size;
    }

    @Override
    public T get(int index) {
        if (index>=size){
            throw new RuntimeException("超出栈边界");
        }
        if (index<0){
            throw new RuntimeException("无效索引");
        }
        return this.data[index];
    }
    public void resize(){
        T[] tmp= (T[])new Object();
        System.arraycopy(data,0,tmp,0,data.length*2);
        this.data=tmp;
        tmp=null;
    }

    public static void main(String[] args) {
        MyStack<String> stack=new MyStack<>();
        stack.add("a");
        stack.add("b");
        stack.add("c");
        stack.add("d");
        System.out.println(stack.size());
        System.out.println(stack.get(2));
        System.out.println(stack.remove());
        stack.add("xxq");
        stack.add("bixin");
        stack.add("yuer");

        System.out.println(stack.size());
        System.out.println(stack.get(0));
        System.out.println(stack.get(1));
        System.out.println(stack.get(2));
        System.out.println(stack.get(3));
        System.out.println(stack.get(4));
        System.out.println(stack.get(5));


    }
}
