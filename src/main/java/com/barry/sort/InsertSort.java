package com.barry.sort;

public class InsertSort {
    public static void main(String[] args) {
        SqList l = new SqList();
        int[] r = new int[]{0,2,4,6,8,0,1,3,5,7,9};
        l.setR(r);
        l.setLength(r.length-1);
        InsertSort is = new InsertSort();
        is.insertSort(l);
        for (int i = 1; i < r.length; i++) {
            System.out.println(r[i]);
        }
    }

    public void insertSort(SqList l){
        int[] r = l.getR();
        for (int i = 2; i < r.length; i++) {
            if (r[i]<r[i-1]){
                r[0] = r[i];
                int j ;
                for ( j = i-1; r[j] > r[0] ; j--) {
                    r[j+1]=r[j];
                }
                r[j+1] = r[0];
            }
        }
    }
}
