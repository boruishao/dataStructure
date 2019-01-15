package com.barry.sort;

public class BubbleSort {

    public static void main(String[] args) {
        SqList l = new SqList();
        int[] r = new int[]{0,2,4,6,8,0,1,3,5,7,9};
        l.setR(r);
        l.setLength(r.length-1);
        BubbleSort bs = new BubbleSort();
        bs.bubbleSort(l);
        for (int i = 1; i < r.length; i++) {
            System.out.println(r[i]);
        }
    }

    public void bubbleSort0(SqList l){
        int[] r = l.getR();
        for (int i = 1; i < r.length; i++) {
            for (int j = i+1; j < r.length; j++) {
                if (r[i] > r[j]){
                    l.swap(l,i,j);
                }
            }
        }
    }

    public void bubbleSort(SqList l){
        int[] r = l.getR();
        for (int i =1;i<r.length;i++){
            for(int j = r.length-1;j>i;j--){
                if (r[j-1]>r[j]){
                    l.swap(l,j,j-1);
                }
            }
        }
    }

    public void bubbleSortOptmistic(SqList l){
        int[] r = l.getR();
        boolean flag = true;
        for (int i =1;i<r.length && flag;i++){
            flag = false;
            for(int j = r.length-1;j>i;j--){
                if (r[j-1]>r[j]){
                    l.swap(l,j,j-1);
                    flag =true;
                }
            }
        }
    }

}
