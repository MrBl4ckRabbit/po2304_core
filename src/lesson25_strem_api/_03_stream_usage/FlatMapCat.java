package lesson25_strem_api._03_stream_usage;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class FlatMapCat {
    @NonNull
    private String name;
    private int age;
    private List<String> toys;
}
