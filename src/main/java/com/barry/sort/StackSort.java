package com.barry.sort;

public class StackSort {
    public static void main(String[] args) {
        SqList l = new SqList();
        int[] r = new int[]{0,2,4,6,8,0,1,3,5,7,9};
        l.setR(r);
        l.setLength(r.length-1);
        StackSort ss = new StackSort();
        ss.stackSort(l);
        for (int i = 1; i < r.length; i++) {
            System.out.println(r[i]);
        }
    }

    public void stackSort(SqList l){
        int[] r = l.getR(); //数据从r[1]开始存储
        l.setLength(r.length-1);
        for (int i = l.getLength()/2; i > 0 ; i--) {
            heapAdjust(l,i,l.getLength());
        }


        for (int i = l.getLength();i>1;i--){
            l.swap(l,1,i);
            heapAdjust(l,1,i-1);
        }
    }

    private void heapAdjust(SqList l, int s, int m) {
        int temp = l.getR()[s];
        for (int j = 2*s; j <= m; j*=2) {
            if (j<m && l.getR()[j]<l.getR()[j+1]){
                j++;
            }
            if (temp > l.getR()[j]){
                break;
            }
            l.getR()[s] = l.getR()[j];
            s = j;
        }
        l.getR()[s] = temp;
    }
}
