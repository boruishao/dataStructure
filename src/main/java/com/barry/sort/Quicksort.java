package com.barry.sort;

public class Quicksort {

    public static void main(String[] args) {
        SqList l = new SqList();
        int[] r = new int[]{0,2,4,6,8,0,1,3,5,7,9};
        l.setR(r);
        l.setLength(r.length-1);
        Quicksort qs = new Quicksort();
        qs.quickSort(l);
        for (int i = 1; i < r.length; i++) {
            System.out.println(r[i]);
        }
    }


    public void quickSort(SqList l){
        int[] r = l.getR();
        //optimize 3 , 在数量集小的时候不适用快排。
        if (r.length < 9){
            InsertSort insertSort = new InsertSort();
            insertSort.insertSort(l);
        }else
        sort(r,1,r.length-1);
    }

    public void sort(int[] r,int low ,int high){
        int pivot;
        if (low < high){
            pivot = partiton(r,low,high);
            sort(r,low,pivot -1);
            sort(r,pivot+1,high);
        }
    }

    private int partiton(int[] r ,int low ,int high) {

        //optimize.1 使privtkey为一个稍微靠中间的值
        int m = low + (high-low);
        if (r[low] > r[high]){
            swap(r,low,high);
        }
        if (r[m]>r[high]){
            swap(r,high,m);
        }
        if (r[m]>r[low]){
            swap(r,m,low);
        }

        int pivotKey = r[low];
        //optimize 2 optimize not necessary change
        r[0] = pivotKey;

        while (low < high){
            while (pivotKey < r[high]){
                high--;
            }
            r[low] = r[high];
//            swap(r,low,high);
            while (pivotKey > r[low]){
                low++;
            }
            r[high] = r[low];
//            swap(r,low,high);
        }
        r[low]= r[0];
        return low;
    }

    public void swap(int[] r , int i,int j){
        int temp = r[i];
        r[i] = r[j];
        r[j] = temp;
    }



}
