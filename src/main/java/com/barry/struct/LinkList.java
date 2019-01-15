package com.barry.struct;

public class LinkList extends Node {

    public int size() {
        int i = 1;
        Node p = this.next;
        while (p != null) {
            p = p.next;
            i++;
        }
        return i;
    }

    public int getData() {
        return data.num;
    }

    public ElementType getElem(int i) {
        Node p = this;
        if (i < 1) {
            return null;
        }

        for (int j = 1; j < i && p != null; j++) {
            p = p.next;
        }
        if (p != null) return p.data;

        return null;
    }

    public Boolean insert(int i, Node node) {
        Node p = this;
        if (i < 1) {
            return false;
        }

        for (int j = 2; j < i && p != null; j++) {
            p = p.next;
        }
        if (p == null) {
            return false;
        }
        node.next = p.next;
        p.next = node;
        if (i == 1) {
            ElementType data = this.next.data;
            this.next.data = this.data;
            this.data = data;
        }
        return true;

    }

    public Boolean delete(int i) {
        if (i < 1) {
            return false;
        }
        if (i == 1) {
            if (this.next == null) {
                return false;
            }
            this.data = this.next.data;
            this.next = this.next.next;
            return true;
        }
        Node p = this;
        for (int j = 2; j < i && p.next != null; j++) {
            p = p.next;
        }
        if (p.next != null) {
            p.next = p.next.next;
            return true;
        }
        return false;
    }

    public LinkList createListHead(int i) {
        this.next = null;
        this.data = new ElementType();
        if (i < 1) {
            return null;
        }

        for (int j = 1; j < i; j++) {
            Node node = new Node();
            node.data = new ElementType(j);
            node.next = this.next;
            this.next = node;
        }
        return this;
    }

    public LinkList createListTail(int i) {
        this.next = null;
        this.data = new ElementType();
        if (i < 1) {
            return null;
        }
        Node p = this;
        for (int j = 1; j < i; j++) {
            Node node = new Node();
            node.data = new ElementType(j);
            node.next = null;
            p.next = node;
            p = p.next;
        }
        return this;
    }

}
