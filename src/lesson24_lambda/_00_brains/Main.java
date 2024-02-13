package lesson24_lambda._00_brains;

import org.apache.commons.lang3.StringUtils;

public class Main {
    public static final String BARSIK = "Barsik";

    public static void main(String[] args) {
        var cat1 = new BrainCat();
//        if (BARSIK.equals(cat.getName())) {
//            System.out.println("ok");
//        } else {
//            System.out.println("no");
//        }
        System.out.println(StringUtils.equals(cat1.getName(), BARSIK));
    }
}
