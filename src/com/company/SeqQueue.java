package com.company;
public class SeqQueue {
    Object[] data;
    int front;
    int rear;
    int maxSize;

    public SeqQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = 0;
        this.rear = 0;
        this.data = new Object[this.maxSize];
    }
    public boolean isEmpty() {
        return this.rear == this.front;
    }
    public boolean isFull() {
        return (this.rear+1)%this.maxSize == this.front;
    }
    public void enqueue(Object e) {
        if(this.isFull())
            return;
        this.data[this.rear] = e;
        this.rear = (this.rear+1)%this.maxSize;
    }
    public Object dequeue() {
        if(this.isEmpty())
            return null;
        Object e = this.data[this.front];
        this.front = (this.front+1)%this.maxSize;
        return e;
    }

    public static void main(String[] args) {
        SeqQueue sq = new SeqQueue(10);
        sq.enqueue("张三");
        sq.enqueue("李四");
        Object o = sq.dequeue();
        System.out.print(o);
        Object e = sq.dequeue();
        System.out.print(e);
    }
}
