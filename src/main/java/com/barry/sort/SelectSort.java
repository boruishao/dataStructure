package com.barry.sort;

public class SelectSort {

    public static void main(String[] args) {
        SqList l = new SqList();
        int[] r = new int[]{0,2,4,6,8,0,1,3,5,7,9};
        l.setR(r);
        l.setLength(r.length-1);
        SelectSort ss = new SelectSort();
        ss.selectSort(l);
        for (int i = 1; i < r.length; i++) {
            System.out.println(r[i]);
        }
    }

    public void selectSort(SqList l){
        int min;
        int[] r = l.getR();
        for (int i = 1; i < r.length; i++) {
            min = i;
            for (int j = i+1; j < r.length; j++) {
                if (r[min] > r[j]){
                    min = j;
                }
            }
            if (i != min){
                l.swap(l,i,min);
            }
        }
    }
}
