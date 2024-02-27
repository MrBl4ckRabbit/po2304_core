package lesson26_serializable._03_standart_compose;

import java.io.Serializable;
import java.util.StringJoiner;

public class StandardCat implements Serializable {
    static final long serialVersionUID = 1L;
    static String STATIC_FIELD = "static";
    final String name;
     StandardBox box;

    public StandardCat(String name, StandardBox box) {
        this.name = name;
        this.box = box;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StandardCat.class.getSimpleName() + "[", "]")
                .add("staticfield='" + STATIC_FIELD + "'")
                .add("name='" + name + "'")
                .add("box=" + box)
                .toString();
    }
}
