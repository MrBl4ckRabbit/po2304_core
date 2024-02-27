package lesson27_xml._06_jaxb;

import jakarta.xml.bind.JAXBException;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws JAXBException, IOException {
        var cats=JAXBUtils.unmarshal();
        cats.forEach(System.out::println);

        JAXBUtils.marshal(cats);
    }
}
