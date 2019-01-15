package com.barry.struct.tree;

import com.barry.struct.ElementType;

public class BiTNode {
    public ElementType data =new ElementType();
    public BiTNode lchild ;
    public BiTNode rchild ;
    public BiTNode parent ;

    public BiTNode(){

    }

    public BiTNode(int i){
        this.data = new ElementType(i);
    }
    public ElementType getData() {
        return data;
    }

    public void setData(ElementType data) {
        this.data = data;
    }

    public BiTNode getLchild() {
        return lchild;
    }

    public void setLchild(BiTNode lchild) {
        this.lchild = lchild;
    }

    public BiTNode getRchild() {
        return rchild;
    }

    public void setRchild(BiTNode rchild) {
        this.rchild = rchild;
    }

    public BiTNode getParent() {
        return parent;
    }

    public void setParent(BiTNode parent) {
        this.parent = parent;
    }
}
