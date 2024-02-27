package lesson27_xml._04_dom;

public class Main {
    public static void main(String[] args) {
        var cats = DomParser.parseXML();
        cats.forEach(System.out::println);
    }
}
