package lesson24_lambda._02_func_int;

public class Main {
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 5, 6, 7, 8};

        for (int i : num) {
            if (i < 5) {
                System.out.println(i);
            } else {
                return;
            }
        }

        var aaa = 15 + 59;
        OneParamInterface inter = (v1) -> 15 + v1;
        System.out.println(aaa);
        System.out.println(inter);
    }
}
