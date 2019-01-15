package com.barry.struct.tree;

import com.barry.struct.ElementType;

import java.util.Scanner;

public class BiTree {

    public void preOrderTraverse(BiTNode node){

        if(null == node){
            return;
        }
        System.out.println(node.data.getNum());
        preOrderTraverse(node.lchild);
        preOrderTraverse(node.rchild);
    }

    public void inOrderTraverse(BiTNode node){
        if(null == node){
            return;
        }
        inOrderTraverse(node.lchild);
        System.out.println(node.data.getNum());
        inOrderTraverse(node.rchild);
    }

    public void postOrderTraverse(BiTNode node){
        if (null == node){
            return;
        }
        postOrderTraverse(node.lchild);
        postOrderTraverse(node.rchild);
        System.out.println(node.data.getNum());
    }

    public void createBiTree(BiTNode node){
        ElementType data = new ElementType();
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        if (s.equals("#")){
            node = null;
        }
        else {
            node.data.setNum(Integer.valueOf(s));
            node.lchild = new BiTNode();
            node.rchild = new BiTNode();
            createBiTree(node.lchild);

            createBiTree(node.rchild);
        }
    }

}
