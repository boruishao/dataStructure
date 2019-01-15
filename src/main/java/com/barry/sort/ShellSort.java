package com.barry.sort;

public class ShellSort {

    public static void main(String[] args) {
        SqList l = new SqList();
        int[] r = new int[]{0,2,4,6,8,0,1,3,5,7,9};
        l.setR(r);
        l.setLength(r.length-1);
        ShellSort ss = new ShellSort();
        ss.shellSort(l);
        for (int i = 1; i < r.length; i++) {
            System.out.println(r[i]);
        }
    }

    public void shellSort(SqList l) {
        int[] r = l.getR();

        int increment = r.length;

        do {
            increment = increment / 3 + 1;
            for (int i = increment +1; i < r.length ; i++){
                if (r[i] < r[i-increment]){
                    r[0] = r[i];
                    int j;
                    for ( j = i-increment ; j >0 && r[0]< r[j] ; j-=increment ) {
                        r[j+increment] = r[j];
                    }
                    r[j+increment] = r[0];
                }
            }
        } while (increment > 1);

    }
}
