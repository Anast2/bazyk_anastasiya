package org.example;

import java.io.Serializable;

public class Nurseries implements Serializable {
    private NodeNursery first;
    private NodeNursery last;
    private int size;
    private static final long serialVersionUID = 5L;

    public Nurseries(){
        size = 0;
        first = null;
        last = null;
    }
    public Nurseries(Nursery nursery){
        first = new NodeNursery(nursery);
        last = first;
        size = 1;
    }

    public NodeNursery getFirst(){
        return this.first;
    }
    public int getSize(){
        return size;
    }
    public Nursery getNursery(String name){
        NodeNursery curr = first;
        while(!curr.getNursery().getName().equals(name)){
            curr = curr.getNext();
        }
        return curr.getNursery();
    }
    public NodeNursery getLast() {
        return last;
    }
    public void setLast(NodeNursery last) {
        this.last = last;
    }
    public void setFirst(NodeNursery first) {
        this.first = first;
    }
    public void setSize(int a) {
        size = a;
    }
    public void incSize() {
        size++;
    }
    public void decSize() {
        size--;
    }
    public void checkIn(String name) throws NameException{
        if(check(name)){
            throw new NameException("Nursery \"" + name + "\" does not exist!");
        }
    }
    public boolean check(String name){                // if returns false = there is a nursery
        NodeNursery curr = first;
        while (curr != null){
            if(curr.getNursery().getName().equals(name))
                return false;
            curr = curr.getNext();
        }
        return true;
    }
    public int how_many_cats(){
        int result = 0;
        NodeNursery curr = first;
        while(curr != null){
            result += curr.getNursery().getCats_counter();
            curr = curr.getNext();
        }
        return result;
    }

}

