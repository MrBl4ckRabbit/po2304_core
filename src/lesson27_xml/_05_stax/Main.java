package lesson27_xml._05_stax;

import lesson27_xml._02_base_XML.XMLCat;

public class Main {
    public static void main(String[] args) {
        var cats = StaxParser.parseXml();
        cats.forEach(System.out::println);
    }
}
