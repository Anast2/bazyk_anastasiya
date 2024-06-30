package org.example;

class DataBaseDaoImpl implements DataBaseDao{

    private DataBase dataBase;

    public DataBaseDaoImpl(DataBase dataBase){
        this.dataBase = dataBase;
    }

    @Override
    public Nursery checkNursery(String name) {
        for(int i = 0; i < dataBase.getCurrNurseries(); i++){
            if(dataBase.getNurseries().get(i).getName().equals(name))
                return dataBase.getNurseries().get(i);
        }
        return null;
    }

    @Override
    public void insertNursery(Nursery nursery) throws NurseryException{
        if(checkNursery(nursery.getName()) == null){
            dataBase.getNurseries().add(nursery);
        }
        else
            throw new NurseryException("Nursery with this name already exists");
    }

    @Override
    public void deleteNursery(String name) throws NurseryException{
        if(checkNursery(name) != null){
            for(int i = 0; i < dataBase.getCurrNurseries(); i++){
                if(dataBase.getNurseries().get(i).getName().equals(name)){
                    dataBase.getNurseries().remove(i);
                    return;
                }
            }
        }
        else
            throw new NurseryException("Nursery with this name does not exist");

    }

    public DataBase getDataBase() {
        return dataBase;
    }
}
