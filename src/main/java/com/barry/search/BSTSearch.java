package com.barry.search;

import com.barry.struct.tree.BiTNode;

public class BSTSearch {

    public static void main(String[] args) {
        BSTSearch bstSearch = new BSTSearch();
        int[] a = new int[]{62,88,58,47,35,73,51,99,37,93};
        BiTNode t = null;
        for (int j = 0; j < a.length; j++) {
            bstSearch.insertBST(t,a[j]);
        }

        boolean p = bstSearch.searchBST(t, 35, null);
        System.out.println(p);

    }

    public BiTNode searchBSTParent(BiTNode t ,int key,BiTNode f){
        if (t == null){
            return f;
        }else if (key == t.getData().getNum()){
            return t;
        }else if (key < t.getData().getNum()){
            return searchBSTParent(t.getLchild(),key,t);
        }else{
            return searchBSTParent(t.rchild,key,t);
        }
    }

    public boolean searchBST(BiTNode t, int key, BiTNode f) {
        if (t == null) {
            return false;
        } else if (key == t.getData().getNum()) {
            return true;
        } else if (key < t.getData().getNum()) {
            return searchBST(t.getLchild(), key, t);
        } else {
            return searchBST(t.getRchild(), key, t);
        }
    }

    public BiTNode insertBST(BiTNode t, int key) {
//        BiTNode p = new BiTNode();
        if (!searchBST(t, key, null)) {
            BiTNode p = searchBSTParent(t, key, null);
            BiTNode s = new BiTNode(key);
            if (p == null){
                return s;
//                t.setData(p.getData());
            }else if (key < p.getData().getNum()){
                p.setLchild(s);
            }else {
                p.setRchild(s);
            }
            return p;
        }else {
            return null;  //have the same value.
        }
    }

    public boolean deleteBST(BiTNode t,int key){
        if (t == null){
            return false;
        }else{
            if (key == t.getData().getNum()){
                return delete(t);
            }else if (key < t.getData().getNum()){
                return deleteBST(t.getLchild(),key);
            }else {
                return deleteBST(t.getRchild(),key);
            }
        }
    }

    private boolean delete(BiTNode p) {
        BiTNode q ;
        if (p.rchild == null){
            p=p.lchild;
        }else if (p.lchild == null){
            p=p.rchild;
        }else {
            q =p;
            BiTNode s = p.lchild;
            while (s.rchild !=null){
                q = s ;
                s = s.rchild;
            }
            p.setData(s.getData());
            if (q != p){
                q.rchild = s.lchild;
            }else {
                q.lchild = s.lchild;
            }
        }
        return true;
    }

}
