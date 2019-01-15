package com.barry.struct;

public class String {
    private char[] data = new char[10];

    private int length;

    public char[] getData() {
        return data;
    }

    public void setData(char[] data) {
        this.data = data;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int index(String str){
        for (int i = 0 ; i < length - str.length+1; i++){
            for (int j = 0 ; j < str.length;j++){
                if (data[i+j]==str.data[j]){
                    if (j == str.length-1){
                        return i;
                    }
                    continue;
                }else {
                    break;
                }
            }
        }
        return -1;
    }

    public int index2(String str,int pos){

//        int[] next = getNext(str);
        int i =pos;
        int j =1;
        char[] data = str.getData();
        while (i<this.length && j<str.length+1){
            if (this.data[i]==data[j]){
                i++;
                j++;
            }else {
                i = i-j+1;
                j=0;
//                j = next[j];

            }
        }
        if (j==str.length) return i-j;
        return -1;
    }

    public int[] getNext(String str){
        int i=1;
        int j=0;
        char[] data = str.getData();
        int[] next = new int[str.length+1];
        next[1]=0;
        while (i<str.length){
            if (j==0 || data[i]==data[j]){
                j++;
                i++;
                next[i]=j;
            }
            else {
                j = next[j];
            }
        }
        int[] next2 = new int[str.length];
        for (int k =1 ; k < str.length+1;k++){
            next2[k-1]=next[k];
        }
        return next2;
    }


}
