package lesson27_xml._04_dom;

import lesson27_xml._02_base_XML.XMLCat;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomParser {
    public static List<XMLCat> parseXML() {
        var cats = new ArrayList<XMLCat>();

        try {
            var factory = DocumentBuilderFactory.newInstance();
            var builder = factory.newDocumentBuilder();
            var document = builder.parse(new FileInputStream("src/lesson27_xml/_04_dom/cats.xml"));
            document.getDocumentElement().normalize();
            var root = document.getDocumentElement();
            var nodeList = document.getElementsByTagName("cat");
            for (int i = 0; i < nodeList.getLength(); i++) {
                var node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    var element = (Element) node;
                    var cat = new XMLCat();
                    cat.setId(Integer.parseInt(element.getAttribute("id")));
                    cat.setName(element.getElementsByTagName("name").item(0).getTextContent());
                    cat.setAge(Integer.parseInt(element.getElementsByTagName("age").item(0).getTextContent()));
                    cats.add(cat);
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
        return cats;
    }
}
