package com.barry;

import com.barry.struct.ElementType;
import com.barry.struct.LinkList;
import com.barry.struct.Node;
import com.barry.struct.SqQueue;
import com.barry.struct.tree.BiTNode;
import com.barry.struct.tree.BiTree;
import org.junit.Test;

public class Struct {
    public static void main(String[] args) {
        BiTree tree = new BiTree();
        BiTNode node = new BiTNode();
        tree.createBiTree(node);
        tree.inOrderTraverse(node);
        System.out.println("========");
        tree.postOrderTraverse(node);

    }

    //link list
    @Test
    public void test1() {
        LinkList linkList = new LinkList();
        LinkList listHead = linkList.createListHead(3);
        System.out.println(listHead.size());

        LinkList listTail = linkList.createListTail(4);
        System.out.println(listTail.size());

        Boolean delete = listTail.delete(2);
        System.out.println(delete);
        System.out.println(listTail.size());

        Boolean insert = listTail.insert(2, new Node());
        System.out.println(insert);
        System.out.println(listTail.size());
        Node p = listHead;

        System.out.println("=-----------------");
        do {
            System.out.println(p.getData());
            p = p.next();
        } while (p != null);

    }

    //queue
    @Test
    public void test2() {
        SqQueue sqQueue = new SqQueue();
        System.out.println(sqQueue.getQueueLength());
        sqQueue.enQueue(new ElementType(1));
        sqQueue.enQueue(new ElementType(2));
        System.out.println(sqQueue.getQueueLength());
        ElementType e = new ElementType();
        boolean b = sqQueue.deQueue(e);
        System.out.println(b + " " + e.getNum());
    }

    //String
    @Test
    public void test3() {
        com.barry.struct.String a = new com.barry.struct.String();
        com.barry.struct.String b = new com.barry.struct.String();
        a.setData(new char[]{'a', 'b', 'c', 'd', 'x','b','c','d','d'});
        a.setLength(9);
        b.setData(new char[]{'b', 'c', 'd','d'});
        b.setLength(4);

        int index = a.index2(b,0);
        System.out.println(index);
    }

    //KMP
    @Test
    public void test4(){
        com.barry.struct.String a = new com.barry.struct.String();
        a.setData(new char[]{'6','a', 'b', 'c', 'a', 'b','x'});
        a.setLength(6);
        int[] next = a.getNext(a);
        for (int i : next) {
            System.out.println(i);
        }

    }

    //BiTree
    @Test
    public void test5(){
        int top =0;

        int[] stack = new int[3];

        stack[top] = 1;
        System.out.println(stack[0]);
        System.out.println(stack[1]);
    }


    @Test
    public void test6(){
        Node node = new Node();
        toNull(node);
        System.out.println(node);
    }
    public void toNull(Object obj){
        obj = 123;
    }



}
