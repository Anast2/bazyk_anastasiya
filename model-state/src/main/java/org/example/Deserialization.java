package org.example;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserialization {
    private static String cats_file = "cats";
    private static String nurseries_file = "nurseries";

    public static Cat[] cats_deserialization() throws IOException {
        Cat[] cats = new Cat[0];
        if(new File(cats_file).exists()){
            try(FileInputStream inputStream = new FileInputStream(cats_file);
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
                cats = (Cat[]) objectInputStream.readObject();
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage() + "Cats deserialization exception!");
            }
        }
        return cats;
    }
    public static Nurseries nurseries_deserialization() throws IOException {
        Nurseries nurseries = new Nurseries();
        if(new File(nurseries_file).exists()){
            try(FileInputStream inputStream = new FileInputStream(nurseries_file);
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
                 nurseries = (Nurseries) objectInputStream.readObject();
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage() + "Nurseries deserialization exception!");
            }
        }
        return nurseries;
    }

}
