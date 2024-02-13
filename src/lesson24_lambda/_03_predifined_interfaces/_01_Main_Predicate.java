package lesson24_lambda._03_predifined_interfaces;

import org.apache.commons.lang3.StringUtils;

import java.util.function.Predicate;

public class _01_Main_Predicate {
    public static void main(String[] args) {
        //T->boolean
        Predicate<Integer> negative = integer -> integer < 0;
        System.out.println(negative.test(-6));
        System.out.println(negative.test(5));

        Predicate<String> containsA = s -> s.contains("A");
        Predicate<String> containsB = s -> s.contains("B");

        System.out.println(containsA.and(containsB).test("ACD"));
        System.out.println(containsA.or(containsB).test("ACD"));
        StringUtils.containsAny("VAC", "V", "C");
    }
}
