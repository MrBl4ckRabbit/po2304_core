package lesson29_annotation._03_retention;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        var annClassObject = AnnotatedClass.class;
        var annClassObject = new AnnotatedClass();
        var annotation = annClassObject.getClass().getAnnotations();
        System.out.println("Quantity Runtime annotations " + annotation.length);
        Arrays.stream(annotation).forEach(System.out::println);
    }
}
