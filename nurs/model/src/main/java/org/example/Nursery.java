package org.example;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Nursery implements Serializable {

    private String name;

    private List<Cat> cats;

    private int currSize;

    private static final long SERIAL_VERSION_UID = 3L;

    public  Nursery(String name){
        this.name = name;
        this.cats = new ArrayList<Cat>();
        currSize = 0;
    }

    public int getCurrSize() {
        return this.cats.size();
    }

    public List<Cat> getCats() {
        return cats;
    }

    public void setCats(List<Cat> cats) {
        this.cats = cats;
    }

    public void setCurrSize(int currSize) {
        this.currSize = currSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode(){
        int hash = 31;
        hash = 31 * hash + this.currSize;
        hash = 31 * hash + this.cats.hashCode();
        return hash;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("Nursery[").append(this.name);
        for (Cat cat: cats) {
            result.append(", ");
            result.append(cat.toString());
        }
        result.append("]");
        return result.toString();
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null || getClass() != obj.getClass())
            return false;
        final Nursery nursery = (Nursery) obj;
        return this.name.equals(nursery.getName()) && this.currSize == nursery.getCurrSize() && this.cats.equals(nursery.getCats());
    }

}
