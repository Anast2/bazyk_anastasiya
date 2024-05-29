package org.example;

import java.io.Serializable;

public class NodeNursery implements Serializable {
    private Nursery nursery;
    private NodeNursery next;
    private static final long serialVersionUID = 4L;

    public NodeNursery(Nursery nursery){
        this.nursery = nursery;
        next = null;

    }

    public NodeNursery getNext() {
        return next;
    }
    public Nursery getNursery() {
        return nursery;
    }
    public void setNext(NodeNursery next) {
        this.next = next;
    }
    public void setNursery(Nursery nursery) {
        this.nursery = nursery;
    }
}

