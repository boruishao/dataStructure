package com.barry.sort;

public class MergeSort {

    public static void main(String[] args) {
        SqList l = new SqList();
        int[] r = new int[]{0, 2, 4, 6, 8, 0, 1, 3, 5, 7, 9};
        l.setR(r);
        l.setLength(r.length -1);
        MergeSort ms = new MergeSort();
        ms.mergeSort2(l);
        for (int i = 1; i < r.length; i++) {
            System.out.println(r[i]);
        }
    }

    public void mergeSort(SqList l) {
        int[] r = l.getR();
        mSort(r, r, 1, r.length-1 );
    }

    private void mSort(int[] sr, int[] tr1, int s, int t) {

        int[] tr2 = new int[tr1.length];
        if (s == t) {
            tr1[s] = sr[s];
        } else {
            int m = (s + t) / 2;
            mSort(sr, tr2, s, m);
            mSort(sr, tr2, m + 1, t);
            merge(tr2, tr1, s, m, t);
        }

    }

    private void merge(int[] sr, int[] tr, int i, int m, int n) {
        int k = i;
        int j = m + 1;
        for (; j <= n && i <= m; k++) {
            if (sr[i] < sr[j]) {
                tr[k] = sr[i++];
            } else {
                tr[k] = sr[j++];
            }
        }
        if (i <= m) {
            for (int l = 0; l <= m - i; l++) {
                tr[k + l] = sr[i + l];
            }
        }
        if (j <= n) {
            for (int l = 0; l <= n - j; l++) {
                tr[k + l] = sr[j + l];
            }
        }
    }

    public void mergeSort2(SqList l){
        int[] r = l.getR();
        int[] tr = new int[r.length];
        int k = 1 ;
        while (k < l.getLength()){
            mergePass(r,tr,k,l.getLength());
            k*=2;
            mergePass(tr,r,k,l.getLength());
            k*=2;
        }
    }

    private void mergePass(int[] sr, int[] tr, int s, int n) {
        int i = 1;
        int j;
        while (i <= n-2*s+1){
            merge(sr,tr,i,i+s-1,i+2*s-1);
            i = i + 2*s;
        }
        if (i < n-s+1){
            merge(sr,tr,i,i+s-1,n);
        }else{
            for (j = i; j <= n; j++){
                tr[j] = sr[j];
            }
        }
    }
}
