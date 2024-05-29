package org.example;
import java.io.*;
import java.util.Scanner;
// in the menu section only options {1,2,6} exit work
public class Main {
    public static void printMenu(){
        System.out.println("Menu: ");
        System.out.println("1. Add a new cat nursery");
        System.out.println("2. Add a cat");
        System.out.println("3. Delete a cat");
        System.out.println("4. Transfer of cats from the nursery");
        System.out.println("5. Current status of the nursery");
        System.out.println("6. Info about a nursery");
        System.out.println("7. Info about a cat");
        System.out.println("Enter a command number please. To end the program, enter \"exit\":");
    }
    public static String nameNurs(Nurseries nurseries, String name){
        boolean accept;
        while (true) {
            accept = true;
            name = scanner.nextLine();
            try {
                nurseries.checkIn(name);

            } catch (NameException e) {
                accept = false;
                System.out.print(e.getMessage());
                System.out.println("Choose an other nursery: ");
            } finally {
                if (accept)
                    break;
            }
        }
        return name;
    }
    public static Scanner scanner = new Scanner(System.in);

    public static void main( String[] args ) throws IOException, NameException {
        CatService catService = new CatService();
        NurseryService nurseryService = new NurseryService();
        Nurseries nurseries = Deserialization.nurseries_deserialization();
        if(nurseries.getSize() > 0){          // cats deserialization if there is >0 nurseries
          Cat[] cats = Deserialization.cats_deserialization();
            for (int c = 0; c < cats.length; c++) {
                Cat cat = cats[c];
                Nursery nursery = nurseries.getNursery(cat.getNursery_name());
                nursery.insert(cat);
            }
        }
            printMenu();
        boolean accept;
        while (true) {
            String name;
            String command = scanner.next();
            switch (command.charAt(0)) {
                case 'e':
                    Serialization.nurseries_serialization(nurseries);
                    Cat[] cats = new Cat[nurseries.how_many_cats()];
                    NodeNursery curr = nurseries.getFirst();
                    int c = 0;
                    while (curr != null){                                     // loop for all of nurseries
                        Node curr2 = curr.getNursery().getFirst();
                        while(curr2 != null){
                            cats[c] = curr2.getCat();
                            c++;
                            curr2 = curr2.getNext();
                        }
                        curr = curr.getNext();
                    }
                    Serialization.cats_serialization(cats);
                    return;
                case '1':
                    System.out.println("Enter a name for a new nursery: ");
                    Nursery nursery = null;
                    while (true) {
                        accept = true;
                        name = scanner.nextLine();
                        name = scanner.nextLine();
                        try {
                            nursery = new Nursery(name);
                            nurseryService.insert(nurseries, nursery);
                        } catch (NullPointerException | NameException e) {
                            accept = false;
                            System.out.print(e.getMessage() + ' ');
                            System.out.println("Enter a name again: ");
                        } finally {
                            if (accept)
                                break;
                        }
                    }
                    break;
                case '2':
                    System.out.println("Enter a name for a new cat: ");
                    Cat cat = null;
                    while (true) {
                        accept = true;
                        name = scanner.nextLine();
                        name = scanner.nextLine();
                        try {
                            cat = new Cat(name, null);
                        } catch (NullPointerException e) {
                            accept = false;
                            System.out.print(e.getMessage() + ' ');
                            System.out.println("Enter a name again: ");
                        } finally {
                            if (accept)
                                break;
                        }
                    }
                    System.out.println("Enter a name of a nursery where the cat should be placed: ");
                    nurseryService.print(nurseries);
                    String a = nameNurs(nurseries, name);
                    cat.setNursery_name(a);
                    while (true) {
                        accept = true;
                        try {
                            Nursery temp = nurseries.getNursery(a);
                            catService.insert(temp, cat);
                        } catch (NameException e) {
                            accept = false;
                            System.out.print(e.getMessage());
                            System.out.println("Choose an other nursery: ");
                            name = scanner.nextLine();
                        } finally {
                            if (accept)
                                break;
                        }
                    }
                    break;
                case '6':
                    System.out.println("Enter a name for a nursery: ");
                    nurseryService.print(nurseries);
                    name = scanner.nextLine();
                    System.out.println(nurseries.getNursery(nameNurs(nurseries, name)));
                    break;
            }
            printMenu();
        }
    }
}
