package com.barry.search;

public class Binary_search {

    public static void main(String[] args) {
        int[] a = new int[]{-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12};
        int key = 9;
        Binary_search bs = new Binary_search();
        int i = bs.binarySearch(a, a.length - 1, key);
        int j = bs.fibonacciSearch(a, 10, key);
        System.out.println(i);
        System.out.println(j);
    }

    public int binarySearch(int[] a, int n, int key) {
        int high = n;
        int low = 0;
        int index;
        while (low <= high) {
            index = (high + low) / 2;

            if (key < a[index]) {
                high = index - 1;
            }
            if (key > a[index]) {
                low = index + 1;
            }
            if (key == a[index]) {
                return index;
            }
        }
        return -1;
    }

    //改变取index的策略，适合表长大，值分布均匀就的。
    public int insertBinarySearch(int[] a, int n, int key) {
        int high = n;
        int low = 0;
        int index;
        while (low <= high) {
            index = low + ((key - a[low]) / (a[high] - a[low])) * (high - low);
            if (key < a[index]) {
                high = index - 1;
            }
            if (key > a[index]) {
                low = index + 1;
            }
            if (key == a[index]) {
                return index;
            }
        }
        return -1;
    }


    //fibonacci
    int[] f = new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89};

    public int fibonacciSearch(int[] a, int n, int key) {
        int index;
        int low = 0;
        int high = n;
        int k = 0;
        while (n > f[k] - 1) {
            k++;
        }

        for (int i = n; i < f[k] - 1; i++) {
            a[i] = a[n];
        }

        while (low <= high) {
            index = low + f[k - 1] - 1;
            if (key < a[index]) {
                high = index - 1;
                k = k - 1;
            }
            if (key > a[index]) {
                low = index + 1;
                k = k - 2;
            }
            if (key == a[index]) {
                if (index <= n) {
                    return index;
                } else {
                    return n;
                }
            }
        }
        return -1;
    }
}
