package com.barry.sort;

public class SqList {
    private final int MAXSIZE=10;

    private int[] r = new int[MAXSIZE+1]; //int[0] 存储的是哨兵，或临时变量。
    private  int length;

    public int[] getR() {
        return r;
    }

    public void setR(int[] r) {
        this.r = r;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void swap(SqList l , int i,int j){
        int[] r = l.getR();
        int temp = r[i];
        r[i] = r[j];
        r[j] = temp;
        l.setR(r);
    }
}
