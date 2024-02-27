package lesson26_serializable._02_standart_inheritance;

import java.io.Serial;
import java.io.Serializable;
import java.util.StringJoiner;

public class Child extends Parent implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    int childField;


    public Child(int childField) {
        System.out.println("Inside child constructor");
        this.childField = childField;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Child.class.getSimpleName() + "[", "]")
                .add("childField=" + childField)
                .add("parentField=" + parentField)
                .toString();
    }
}
