package lesson24_lambda._00_brains;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class BrainCat implements Comparable<BrainCat> {
    @NonNull
    private String name;
    private int age;


    @Override
    public int compareTo(BrainCat cat) {

        return name.compareTo(cat.getName());
    }
}
