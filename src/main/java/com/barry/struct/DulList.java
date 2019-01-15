package com.barry.struct;

public class DulList extends DulNode {

    public boolean insert(int i, DulNode node) {

        if (i == 1) {

            node.next = this.next;
            node.prior = this;
            this.next.prior = node;
            this.next = node;

            ElementType data = node.data;
            node.data = this.data;
            this.data = data;
            return true;
        }
        if (i > 1) {
            DulNode p = this;
            for (int j = 2; j < i && p!=null; j++) {
                 p = p.next;
            }

            if (p == null){
                return false;
            }
            node.next = p.next;
            node.prior = p;
            p.next.prior = node;
            p.next = node;
            return true;
        }
        return false;

    }

    public boolean delete(int i){
        if (i > 1){
            DulNode p = this.next;
            for (int j = 1; j < i && p != null; j++) {
                p = p.next;
            }
            if (p == null){
                return false;
            }
            p.prior.next = p.next;
            p.next.prior=p.prior;
            return true;
        }
        return false;
    }
}
