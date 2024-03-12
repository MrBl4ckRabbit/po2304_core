package lesson29_annotation._02_target;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException {
        var demoObject = DemoClass.class;
        readAnnotation(demoObject);
        var method=demoObject.getMethod("doSomething");
        readAnnotation(method);
    }

    private static void readAnnotation(AnnotatedElement element) {
        try {
            System.out.println("\n Find annotations in " + element.getClass().getName());
            var annotations = element.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof JavaFileInfo fileInfo) {
                    System.out.println("Author: " + fileInfo.name());
                    System.out.println("Version: " + fileInfo.value());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
