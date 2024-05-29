package org.example;
import java.io.*;

public class Serialization {
    public static String cats_file = "cats";
    public static String nurseries_file = "nurseries";

    public static void cats_serialization(Cat[] cats) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(cats_file);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)){
                out.writeObject(cats);
        }
        catch (IOException e){
            System.out.println(e.getMessage() + "Cats serialization exception!");
        }
    }
    public static void nurseries_serialization(Nurseries nurseries) throws IOException{
        try (FileOutputStream fileOut = new FileOutputStream(nurseries_file);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)){
             out.writeObject(nurseries);
        }
        catch (IOException e){
            System.out.println(e.getMessage() + "Nurseries serialization exception!");
        }
    }

}
