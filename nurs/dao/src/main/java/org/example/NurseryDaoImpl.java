package org.example;

public class NurseryDaoImpl implements NurseryDao{

    private Nursery nursery;

    public NurseryDaoImpl(Nursery nursery){
        this.nursery = nursery;
    }

    @Override
    public void insertCat( Cat cat) throws CatException{
        if(getCatById(cat.getId()) != null)
            throw new CatException("cat witch this name already exists!");
        nursery.getCats().add(cat);
    }

    @Override
    public void deleteCatById(int id) throws CatException{
        if(getCatById(id) != null){
            for(int i = 0; i < nursery.getCurrSize(); i++){
                if(nursery.getCats().get(i).getId() == id){
                    nursery.getCats().remove(i);
                    return;
                }
            }
        }
        else
            throw new CatException("cat witch this name does not exists!");
    }

    @Override
    public Cat getCatById(int id){
        for(int i = 0; i < nursery.getCurrSize(); i++){
            if(nursery.getCats().get(i).getId() == id){
                return nursery.getCats().get(i);
            }
        }
        return null;
    }

    public Nursery getNursery() {
        return nursery;
    }
}
