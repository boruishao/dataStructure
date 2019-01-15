package com.barry.struct.tree;

public enum PointerTag {
    Link(0),
    Thread(1);
    private Integer tag;

    PointerTag(Integer tag) {
        this.tag = tag;
    }

    public Integer getTag(){
        return tag;
    }

}
