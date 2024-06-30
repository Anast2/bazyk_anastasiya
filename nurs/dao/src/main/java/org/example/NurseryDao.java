package org.example;

public interface NurseryDao {

    void insertCat(Cat cat) throws CatException;

    void deleteCatById(int id) throws CatException;

    Cat getCatById(int id);

}
