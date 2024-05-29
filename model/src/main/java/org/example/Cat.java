package org.example;
import java.io.Serializable;
import java.util.Objects;

public class Cat implements Serializable {
    private String name;
    private String nursery_name;
    private static final long serialVersionUID = 1L;

    public Cat(String name, String nursery_name) throws NullPointerException{
        if(name == null || name.length() == 0 || (name.length() > 0 && name.charAt(0) == ' ') ){
            throw new NullPointerException("Name cannot be empty!");
        }
        this.name = name;
        this.nursery_name = nursery_name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) throws NullPointerException{
        if(name == null || name.length() == 0 || (name.length() > 0 && name.charAt(0) == ' ') ){
            throw new NullPointerException("Name cannot be empty!");
        }
        this.name = name;
    }
    public String getNursery_name() {
        return nursery_name;
    }
    public void setNursery_name(String nursery_name) {
        this.nursery_name = nursery_name;
    }
    @Override
    public String toString(){
        return "{" +  this.name + ", " + this.nursery_name + "}";
    }
    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        final Cat cat = (Cat) obj;
        if(!Objects.equals(this.name, cat.name))
            return false;
        if(!this.nursery_name.equals(cat.nursery_name))
            return false;

        return true;
    }
    @Override
    public int hashCode(){
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.name);
        hash = 19 * hash + Objects.hashCode(this.nursery_name);
        return hash;
    }
}
