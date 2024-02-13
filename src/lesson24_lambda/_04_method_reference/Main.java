package lesson24_lambda._04_method_reference;

import lesson24_lambda._00_brains.BrainCat;

import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Function<String, Boolean> function = str -> Boolean.valueOf(str);
        System.out.println(function.apply("true"));
        System.out.println("===================================");
        Function<String, Boolean> function1 = Boolean::valueOf;
        System.out.println(function1.apply("asd"));
        System.out.println("===================================");
        Integer integer = 5;
        var brainCat = new BrainCat("Barsik", 10);
        Supplier<String> supplier = brainCat::toString;
        System.out.println(supplier.get());
        System.out.println("===================================");
        Function<String, String> function2 = String::toLowerCase;
        System.out.println(function2.apply("UHhJKMNH"));
        System.out.println("===================================");
        Function<String, BrainCat> function3 = BrainCat::new;
        System.out.println(function3.apply("Murzik"));


    }
}
