package lesson24_lambda._03_predifined_interfaces;

import java.util.function.Supplier;

public class _04_Main_Supplier {
    public static void main(String[] args) {
        var str="One";
        Supplier<String> supplier1= str::toUpperCase;

        System.out.println(supplier1.get());
    }
}
