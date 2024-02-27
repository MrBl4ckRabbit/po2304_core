package lesson27_xml._02_base_XML;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
@NoArgsConstructor
@Data
public class XMLCat {
    private int id;
    private String name;
    private int age;
}
