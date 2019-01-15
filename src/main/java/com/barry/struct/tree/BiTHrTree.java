package com.barry.struct.tree;

public class BiTHrTree {
    BiThrNode pre;

    void inThreading(BiThrNode node) {
        if (node != null) {
            inThreading(node.lchild);
            if (node.lchild == null) {
                node.ltag = PointerTag.Thread;
                node.lchild = pre;
            }
            if (pre!= null && pre.rchild == null) {
                pre.rtag = PointerTag.Thread;
                pre.rchild = node;
            }
            pre = node;
            inThreading(node.rchild);
        }
    }

    /**
     *    node is headPoint, lchild is the root of the tree, rchild is tail of the tree.
     *    And the rchild of the tail node is point to headPoint
     */
    public void inOrderTraverseThr(BiThrNode headPoint){
        BiThrNode p =  headPoint.lchild ;
        while (p!=headPoint){
            while (p.ltag == PointerTag.Link){
                p = p.lchild;
            }
            System.out.println(p.data.getNum());
            while (p.rtag==PointerTag.Thread && p.rchild != headPoint){
                p = p.rchild;
                System.out.println(p.data.getNum());
            }
            p= p.rchild;
        }
    }
}
