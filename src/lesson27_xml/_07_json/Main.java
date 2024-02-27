package lesson27_xml._07_json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lesson27_xml._02_base_XML.XMLCat;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class Main {
    private static final Gson GSON = new Gson();
    private static final Type TYPE = new TypeToken<List<XMLCat>>() {
    }.getType();

    public static void main(String[] args) throws IOException {
//        var cats = List.of(
//                new XMLCat(1, "Vaska", 2),
//                new XMLCat(2, "Maska", 3),
//                new XMLCat(3, "Murzik", 1),
//                new XMLCat(4, "Pushok", 5)
//        );
//
//        var jsonStr = gson.toJson(cats);
//        var os = new FileOutputStream("src/lesson27_xml/_07_json/cats.json");
//        os.write(jsonStr.getBytes(StandardCharsets.UTF_8));

        List<XMLCat> cats = GSON.fromJson(new FileReader("src/lesson27_xml/_07_json/cats.json"), TYPE);
        cats.forEach(System.out::println);

    }
}
