package org.example;
import java.io.Serializable;
import java.util.Objects;

public class Cat implements Serializable {

    private int id;

    private String name;

    private String nursery_name;

    private static final long SERIAL_VERSION_UID = 1L;

    public Cat(int id, String name, String nursery_name){
        this.id = id;
        this.name = name;
        this.nursery_name = nursery_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "Cat[" +  this.name + ", " + this.nursery_name + "]";
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null || getClass() != obj.getClass())
            return false;
        final Cat cat = (Cat) obj;
        return Objects.equals(this.name, cat.name) && this.nursery_name.equals(cat.nursery_name) && this.id == cat.getId();
    }

    @Override
    public int hashCode(){
        int hash = 31;
        hash = 31 * hash + this.name.hashCode();
        hash = 31 * hash + this.id;
        hash = 31 * hash + this.nursery_name.hashCode();
        return hash;
    }

}
