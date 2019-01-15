package com.barry.search;

public class HashSearch {
    private final int SUCCESS = 1;
    private final int UNSUCCESS = 0;
    private final int HASHSIZE = 12;
    private final int NULLKEY = -32768;

    private int m= 0;

    public boolean initHashTable(HashTable h){
        m = HASHSIZE;
        h.setCount(m);
        h.setElem(new int[m]);
        for (int i = 0; i < m; i++) {
            h.getElem()[i] = NULLKEY;
        }
        return true;
    }

    private int hash(int key){
        return key % m;
    }

    public void insertHash(HashTable h,int key){
        int addr = hash(key);
        while (h.getElem()[addr] != NULLKEY){
            addr = hash(addr+1);
        }
        int[] elem = h.getElem();
        elem[addr] = key;
        h.setElem(elem);
    }

    public int searchHash(HashTable h,int key){
        int addr = hash(key);
        while (h.getElem()[addr]!=key){
            addr = hash(addr + 1);
            if (h.getElem()[addr]==NULLKEY || addr == hash(key)){
                return UNSUCCESS;
            }
        }
        return SUCCESS;
    }
}
