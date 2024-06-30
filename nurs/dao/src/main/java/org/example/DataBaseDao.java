package org.example;

public interface DataBaseDao {

    void insertNursery(Nursery nursery) throws NurseryException;

    void deleteNursery(String name) throws NurseryException;

    Nursery checkNursery(String name);

}
