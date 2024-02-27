package lesson26_serializable._03_standart_compose;

import java.io.*;
import java.util.List;

public class Main {
    public static final String PATH_TO_FILE = "src/lesson26_serializable/_03_standart_compose/save.save";

    public static void main(String[] args) {
        var murzik = new StandardCat("Murzik", new StandardBox(List.of("Toy1", "Toy2")));
        try (
                var os = new FileOutputStream(PATH_TO_FILE);
                var oos = new ObjectOutputStream(os);
                var is = new FileInputStream(PATH_TO_FILE);
                var ois = new ObjectInputStream(is)) {

            oos.writeObject(murzik);
            System.out.println(murzik);
            StandardCat.STATIC_FIELD = "new value";
            var fromFile = (StandardCat) ois.readObject();
            System.out.println(fromFile);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
