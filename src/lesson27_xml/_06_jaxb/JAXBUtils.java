package lesson27_xml._06_jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JAXBUtils {
    public static final String PATH_TO_FILE = "src/lesson27_xml/_06_jaxb/cats.xml";
    public static final String PATH_TO_OUT = "src/lesson27_xml/_06_jaxb/out.xml";

    public static List<CatJXB> unmarshal() throws JAXBException, FileNotFoundException {
        var jaxbContext = JAXBContext.newInstance(CatAggregator.class);
        var unmarshaller = jaxbContext.createUnmarshaller();
        var catAggregator = (CatAggregator) unmarshaller.unmarshal(new FileReader(PATH_TO_FILE));
        return catAggregator.getCats();
    }

    public static void marshal(List<CatJXB> cats) throws JAXBException, IOException {
        var catAggregator = new CatAggregator();
        catAggregator.setCats(cats);
        var jaxbContext = JAXBContext.newInstance(CatAggregator.class);
        var marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(catAggregator, new FileWriter(PATH_TO_OUT));

    }
}
