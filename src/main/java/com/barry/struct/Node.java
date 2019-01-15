package com.barry.struct;

public class Node {
    ElementType data = new ElementType();
    public Node next = null;

    public boolean hasNext() {
        if (next == null) {
            return false;
        } else return true;
    }

    public int getData() {
        return data.num;
    }

    public Node next(){
        return this.next;
    }
}
