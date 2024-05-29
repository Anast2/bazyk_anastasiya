package org.example;
import java.io.Serializable;

public class Node  {
    private Cat cat;
    private Node next;
    private Node prev;
    private static final long serialVersionUID = 2L;

    public Node(Cat cat){
        this.cat = cat;
        next = null;
        prev = null;
    }

    public Node getNext(){
        return this.next;
    }
    public Node getPrev(){
        return this.prev;
    }
    public void setNext(Node next){
        this.next = next;
    }
    public void setPrev(Node prev) {
        this.prev = prev;
    }
    public Cat getCat(){
        return this.cat;
    }
}




