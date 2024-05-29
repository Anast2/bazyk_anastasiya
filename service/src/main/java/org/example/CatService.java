package org.example;

public class CatService {

    public void insert(Nursery nursery, String name) throws NameException {
        if(nursery.check(name) && nursery.getFirst() != null){
            nursery.incCatsCounter();
            Cat cat = new Cat(name, nursery.getName());
            nursery.getLast().setNext(new Node(cat));
            nursery.getLast().getNext().setPrev(nursery.getLast());
            nursery.setLast(nursery.getLast().getNext());
        }
        else if(nursery.getFirst() == null){
            nursery.incCatsCounter();
            nursery.setFirst(new Node(new Cat(name, nursery.getName())));
            nursery.setLast(nursery.getFirst());
        }
        else{
            throw new NameException("Cat with this name already exist! ");
        }
    }
    public void insert(Nursery nursery, Cat cat) throws NameException {
        if(nursery.check(cat.getName()) && nursery.getFirst() != null){
            nursery.incCatsCounter();
            nursery.getLast().setNext(new Node(cat));
            nursery.getLast().getNext().setPrev(nursery.getLast());
            nursery.setLast(nursery.getLast().getNext());
        }
        else if(nursery.getFirst() == null){
            nursery.incCatsCounter();
            nursery.setFirst(new Node(cat));
            nursery.setLast(nursery.getFirst());
        }
        else{
            throw new NameException("Cat with this name already exist! ");
        }
    }
    public void delete(Nursery nursery, String name) throws NameException{
        if(!nursery.check(name) && nursery.getFirst() != null){
            nursery.decCatsCounter();
            Node curr = nursery.getFirst();
            if(nursery.getFirst().getCat().getName().equals(name) && nursery.getFirst() != nursery.getLast()){
                nursery.setFirst(nursery.getFirst().getNext());
                nursery.getFirst().setPrev(null);
                return;
            }
            while(!curr.getNext().getCat().getName().equals(name)){
                curr = curr.getNext();
            }
            if(curr.getNext() == nursery.getLast()){
               nursery.setLast(curr);
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
    public void delete(Nursery nursery, Cat cat) throws NameException{
        if(!nursery.check(cat.getName()) && nursery.getFirst() != null){
            nursery.decCatsCounter();
            Node curr = nursery.getFirst();
            if(nursery.getFirst().getCat().getName().equals(cat.getName()) && nursery.getFirst() != nursery.getLast()){
                nursery.setFirst(nursery.getFirst().getNext());
                nursery.getFirst().setPrev(null);
                return;
            }
            while(!curr.getNext().getCat().getName().equals(cat.getName())){
                curr = curr.getNext();
            }
            if(curr.getNext() == nursery.getLast()){
                nursery.setLast(curr);
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
    public void print(Nursery nursery){
        System.out.print("Nursery \"" + nursery.getName() + "\" : ");
        Node curr = nursery.getFirst();
        while(curr != null){
            System.out.print(curr.getCat()+ " ");
            curr = curr.getNext();
        }
        if(nursery.getFirst() == null){
            System.out.println("is empty");
        }
    }
}
