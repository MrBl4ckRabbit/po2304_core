package lesson29_annotation._04_documented;

public class TestDocumentedClass {
    @TestDocumented(doTestDocument = "Hello from Document")
    public void doSomeDocumented() {
        System.out.println("Test for Documented Annotation");
    }

    @TestNotDocumented(doTestNotDocumented = "Hello from not documented")
    public void doSomeNotDocumented() {
        System.out.println("Test for NotDocumented Annotation");
    }

}
