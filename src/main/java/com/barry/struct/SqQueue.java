package com.barry.struct;

public class SqQueue {

    private final int MAXSIZE = 10;
    private ElementType[] data = new ElementType[MAXSIZE];
    private int front;
    private int real;

    public ElementType[] getData() {
        return data;
    }

    public void setData(ElementType[] data) {
        this.data = data;
    }

    public int getFront() {
        return front;
    }

    private void setFront(int front) {
        this.front = front;
    }

    public int getReal() {
        return real;
    }

    private void setReal(int real) {
        this.real = real;
    }

    public SqQueue initQueue() {
        setFront(0);
        setReal(0);
        return this;
    }

    public int getQueueLength() {
        return (this.real - this.front + MAXSIZE) % MAXSIZE;
    }

    public boolean emptyQueue(){
       return front == real;
    }

    public boolean enQueue(ElementType e){
        //check the queue is full
        if ((real + 1) % MAXSIZE == front){
            return false;
        }
        data[real]=e;
        real = (real+1) % MAXSIZE;
        return true;
    }

    public boolean deQueue(ElementType e){
        if (front == real)
            return false;
        e.setNum(data[front].getNum());
        front = (front +1)% MAXSIZE;

        return true;
    }



}
