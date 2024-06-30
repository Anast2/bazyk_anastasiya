package org.example;

import java.util.*;
public class DataBase {

    private List<Nursery> nurseries;

    private int currSize;

    public DataBase(){
        this.currSize = 0;
        this.nurseries = new ArrayList<Nursery>();
    }

    public int getCurrNurseries() {
        return this.nurseries.size();
    }

    public List<Nursery> getNurseries() {
        return nurseries;
    }

    public void setCurrNurseries(int currNurseries) {
        this.currSize = currNurseries;
    }

    public void setNurseries(List<Nursery> nurseries) {
        this.nurseries = nurseries;
    }

    @Override
    public int hashCode(){
        int hash = 31;
        hash = 31 * hash + this.currSize;
        hash = 31 * hash + this.nurseries.hashCode();
        return hash;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("DataBase[").append(this.currSize);
        for (Nursery nursery: nurseries) {
            result.append(", ");
            result.append(nursery.toString());
        }
        result.append("]");
        return result.toString();
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null || getClass() != obj.getClass())
            return false;
        final DataBase dataBase = (DataBase) obj;
        return this.currSize == dataBase.getCurrNurseries() && this.nurseries.equals(dataBase.getNurseries());
    }

}
