package lesson26_serializable._02_standart_inheritance;

import java.io.*;

public class Main {
    public static final String PATH_TO_FILE = "src/lesson26_serializable/lesson26_serializable_02_standart_inheritance/save.save";

    public static void main(String[] args) {
        System.out.println("Creating child");
//        var child = new Child(1);
       try (
//        var os = new FileOutputStream(PATH_TO_FILE);
//             var oos = new ObjectOutputStream(os);
             var is = new FileInputStream(PATH_TO_FILE);
             var ois = new ObjectInputStream(is)) {
//            System.out.println("Serializing...");
//            oos.writeObject(child);
            System.out.println("Desirializing...");
            var from = (Child) ois.readObject();
            System.out.println(from);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
