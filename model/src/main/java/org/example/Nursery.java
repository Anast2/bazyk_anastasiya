package org.example;
import java.io.Serializable;

public class Nursery implements Serializable {
    private static final long serialVersionUID = 3L;
    private transient Node first;
    private transient Node last;
    private String name;
    private transient int cats_counter;

    public Nursery(String name) throws NullPointerException{
        if(name == null || name.length() == 0 || (name.length() > 0 && name.charAt(0) == ' ')){
            throw new NullPointerException("Name cannot be empty!");
        }
        else{
            this.first = null;
            this.last = null;
            this.name = name;
            cats_counter = 0;
        }
    }
    public void setFirst(Node first) {
        this.first = first;
    }
    public Node getFirst() {
        return first;
    }
    public String getName() {
        return name;
    }
    public int getCats_counter() {
        return this.cats_counter;
    }
    public Cat getCat(String name){
        if(!check(name)){
            Node curr = first;
            while (!curr.getCat().getName().equals(name))
                curr = curr.getNext();
            return curr.getCat();
        }
        return null;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////
    public boolean check(String name){
        if(first != null){
            Node curr = first;
            while (curr != null){
                if(curr.getCat().getName().equals(name))
                    return false;
                curr = curr.getNext();
            }
        }
        return true;
    }
    public void insert(String name) throws NameException {
        if(check(name) && first != null){
            cats_counter++;
            Cat cat = new Cat(name, this.name);
            last.setNext(new Node(cat));
            last.getNext().setPrev(last);
            last = last.getNext();
        }
        else if(first == null){
            cats_counter++;
            first = new Node(new Cat(name, this.name));
            last = first;
        }
        else{
            throw new NameException("Cat with this name already exist!");
        }
    }
    public void insert(Cat cat) throws NameException {
        if(check(cat.getName()) && first != null){
            cats_counter++;
            last.setNext(new Node(cat));
            last.getNext().setPrev(last);
            last = last.getNext();
        }
        else if(first == null){
            cats_counter++;
            first = new Node(cat);
            last = first;
        }
        else{
            throw new NameException("Cat with this name already exist!");
        }
    }
    public void delete(String name) throws NameException{
        if(!check(name) && first != null){
            cats_counter--;
            Node curr = first;
            if(first.getCat().getName().equals(name) && first != last){
                first = first.getNext();
                first.setPrev(null);
                return;
            }
            while(!curr.getNext().getCat().getName().equals(name)){
                curr = curr.getNext();
            }
            if(curr.getNext() == last){
                last = curr;
            }
            curr.setNext(curr.getNext().getNext());
            if(curr.getNext() != null){
                curr.getNext().setPrev(curr);
            }
        }
        else{
            throw  new NameException("Cat does not exist!");
        }
    }
    public void delete(Cat cat) throws NameException{
        if(!check(cat.getName()) && first != null){
            cats_counter--;
            Node curr = first;
            if(first.getCat().getName().equals(cat.getName()) && first != last){
                first = first.getNext();
                first.setPrev(null);
                return;
            }
            while(!curr.getNext().getCat().getName().equals(cat.getName())){
                curr = curr.getNext();
            }
            if(curr.getNext() == last){
                last = curr;
            }
            curr.setNext(curr.getNext().getNext());
            if(curr.getNext() != null){
                curr.getNext().setPrev(curr);
            }
        }
        else{
            throw  new NameException("Cat does not exist!");
        }
    }
    public void print(){
        System.out.print("Nursery \"" + this.name + "\" : ");
        Node curr = first;
        while(curr != null){
            System.out.print(curr.getCat()+ " ");
            curr = curr.getNext();
        }
        if(first == null){
            System.out.println("is empty");
        }
    }
    @Override
    public String toString(){
        return "Name: " +  this.name + "\n" + "Number of cats: " + cats_counter;}

    public Node getLast() {
        return last;
    }
    public void incCatsCounter(){
        cats_counter++;
    }
    public void setLast(Node last) {
        this.last = last;
    }

    public void decCatsCounter() {
        cats_counter--;
    }

    public void setCatsCounter(int a) {
        this.cats_counter = a;
    }
}

