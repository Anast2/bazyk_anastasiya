package org.example;

public class NurseryService {
    public static void transferCats(Nurseries nurseries, String name2, String cat_name, String cat_nursery) throws NameException{
        if(!nurseries.check(cat_nursery) && !nurseries.check(name2)){                  // jesli istnieja obaj pitomniki
            Nursery from = nurseries.getNursery(cat_nursery);
            Nursery to = nurseries.getNursery(name2);
            Cat curr_cat = from.getCat(cat_name);
            from.delete(curr_cat);
            to.insert(curr_cat);
        }
        else if(nurseries.check(name2)){
            throw  new NameException("Destination nursery does not exist!");
        }
    }
    public void insert(Nurseries nurseries, Nursery nursery) throws NameException{
        if(nurseries.check(nursery.getName()) && nurseries.getFirst() != null){
            nurseries.incSize();
            nurseries.getLast().setNext(new NodeNursery(nursery));
            nurseries.setLast(nurseries.getLast().getNext());
        }
        else if(nurseries.getFirst() == null){
            nurseries.incSize();
            nurseries.setFirst( new NodeNursery(nursery));
            nurseries.setLast(nurseries.getFirst());
        }
        else{
            throw new NameException("Nursery with this name already exist!");
        }
    }
    public void delete(Nurseries nurseries, Nursery nursery) throws NameException{
        if(!nurseries.check(nursery.getName()) && nurseries.getFirst() != nurseries.getLast()){
            nurseries.decSize();
            if(nurseries.getFirst().getNursery().getName().equals(nursery.getName())){
                nurseries.setFirst(nurseries.getFirst().getNext());
                return;
            }
            NodeNursery curr = nurseries.getFirst();
            while (!curr.getNext().getNursery().getName().equals(nursery.getName()))
                curr = curr.getNext();
            if(curr.getNext() == nurseries.getLast()){
                curr.setNext(null);
                nurseries.setLast(curr);
                return;
            }
            else
                curr.setNext(curr.getNext().getNext());
        }
        else if(!nurseries.check(nursery.getName()) && nurseries.getLast() == nurseries.getFirst() && nurseries.getSize() > 0){
            nurseries.setFirst(null);
            nurseries.setLast(null);
            nurseries.setSize(0);
        }
        else{
            throw new NameException("Nursery does not exist!");
        }
    }
    public void print(Nurseries nurseries){
        System.out.println("All nurseries: ");
        NodeNursery curr = nurseries.getFirst();
        int i = 1;
        while (curr != null){
            System.out.print(i + ". ");
            System.out.println(curr.getNursery().getName());
            curr = curr.getNext();
        }
        if(nurseries.getFirst() == null){
            System.out.println("Empty!");
        }
    }
}
