package lesson25_strem_api._03_stream_usage;

import lesson24_lambda._00_brains.BrainCat;

import java.util.Comparator;

public class FlatMapComparator implements Comparator<BrainCat> {
    @Override
    public int compare(BrainCat o1, BrainCat o2) {
        return o1.getAge() - o2.getAge();
    }
}
