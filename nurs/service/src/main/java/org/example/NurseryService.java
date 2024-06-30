package org.example;

public class NurseryService {

    public static void transferCats(DataBaseDaoImpl dataBase, String from, String to, int id) throws CatException, NurseryException {
        Nursery nurseryFrom = dataBase.checkNursery(from);
        Nursery nurseryTo = dataBase.checkNursery(to);

        if(nurseryFrom != null && !nurseryFrom.equals(nurseryTo)){
            NurseryDaoImpl nurseryDaoFrom = new NurseryDaoImpl(nurseryFrom);
            NurseryDaoImpl nurseryDaoTo = new NurseryDaoImpl(nurseryTo);

            if(nurseryDaoFrom.getCatById(id) != null && nurseryDaoTo.getCatById(id) == null){
                Cat cat = nurseryDaoFrom.getCatById(id);
                nurseryDaoFrom.deleteCatById(id);
                nurseryDaoTo.insertCat(cat);
            }
            else{
               throw new CatException("check this cat");
            }
        }
        else
            throw new NurseryException("nursery does not exists");
    }

    public void insertNewNursery(DataBaseDaoImpl dataBase, Nursery nursery) throws NurseryException {
        Nursery nursery1 = dataBase.checkNursery(nursery.getName());
        if(nursery1 == null){
            dataBase.insertNursery(nursery);
        }
        else{
            throw new NurseryException("nursery already exist");
        }
    }

    public void deleteNursery(DataBaseDaoImpl dataBase , String name) throws NurseryException {
        Nursery nursery1 = dataBase.checkNursery(name);
        if(nursery1 == null){
            throw new NurseryException("nursery does not exist");
        }
        else{
            dataBase.deleteNursery(name);
        }
    }

    public void printAllNurseries(DataBaseDaoImpl dataBase){
        System.out.println("All nurseries:");
        for(int i = 0; i < dataBase.getDataBase().getCurrNurseries(); i++){
            System.out.println(" " + dataBase.getDataBase().getNurseries().get(i));
        }
    }

}
