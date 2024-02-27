package lesson27_xml._03_sax;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static final String PATH_TO_FILE = "src/lesson27_xml/_03_sax/cats.xml";

    public static void main(String[] args) {

        try {
            var factory = SAXParserFactory.newInstance();
            var parser = factory.newSAXParser();
            var handler = new SaxHandler();
            parser.parse(new FileInputStream(PATH_TO_FILE), handler);
            var cats = handler.getCats();
            cats.forEach(System.out::println);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
