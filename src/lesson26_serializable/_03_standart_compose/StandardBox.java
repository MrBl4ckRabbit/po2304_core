package lesson26_serializable._03_standart_compose;

import java.io.Serializable;
import java.util.List;
import java.util.StringJoiner;

public class StandardBox implements Serializable {
    List<String> toys;

    public StandardBox(List<String> toys) {
        this.toys = toys;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StandardBox.class.getSimpleName() + "[", "]")
                .add("toys=" + toys)
                .toString();
    }
}
