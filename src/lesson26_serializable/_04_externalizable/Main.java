package lesson26_serializable._04_externalizable;

import java.io.*;

public class Main {
    public static final String PATH_TO_FILE = "src/lesson26_serializable/_04_externalizable/save.save";

    public static void main(String[] args) {
        var extFile = new ExtFile("Vasia", "Pupkin", "ThisMyP@s$");
        System.out.println(extFile);
        try (var os = new FileOutputStream(PATH_TO_FILE);
             var oos = new ObjectOutputStream(os);
             var is = new FileInputStream(PATH_TO_FILE);
             var ois = new ObjectInputStream(is)) {
            ;
            oos.writeObject(extFile);
            System.out.println("======================================");
            var fromFile = (ExtFile) ois.readObject();
            System.out.println(fromFile);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
