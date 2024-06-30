package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class State {

    public static final String CATS_FILE = "cats";
    public static final String NURSERIES_FILE = "nurseries";

    public static void catsSerialization(List<Cat> cats) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(CATS_FILE);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(cats);
        } catch (IOException e) {
            System.out.println(e.getMessage() + "Cats serialization exception!");
        }
    }

    public static void nurseries_serialization(List<Nursery> nurseries) throws IOException{
            try (FileOutputStream fileOut = new FileOutputStream(NURSERIES_FILE);
                 ObjectOutputStream out = new ObjectOutputStream(fileOut)){
                out.writeObject(nurseries);
            }
            catch (IOException e){
                System.out.println(e.getMessage() + "Nurseries serialization exception!");
            }
        }

    public static List<Cat> cats_deserialization() throws IOException {
        List<Cat> cats = new ArrayList<>();
        if(new File(CATS_FILE).exists()){
            try(FileInputStream inputStream = new FileInputStream(CATS_FILE);
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
                cats = (ArrayList<Cat>) objectInputStream.readObject();
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage() + "Cats deserialization exception!");
            }
        }
        else{
            throw new FileNotFoundException("file exception");
        }
        return cats;
    }

    public static List<Nursery> nurseries_deserialization() throws IOException {
        List<Nursery> nurseries = new ArrayList<>();
        if(new File(NURSERIES_FILE).exists()){
            try(FileInputStream inputStream = new FileInputStream(NURSERIES_FILE);
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
                nurseries = (ArrayList<Nursery>) objectInputStream.readObject();
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage() + "Nurseries deserialization exception!");
            }
        }
        else{
            throw new FileNotFoundException("file exception");
        }
        return nurseries;
    }

}
