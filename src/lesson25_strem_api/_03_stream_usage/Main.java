package lesson25_strem_api._03_stream_usage;

import lesson24_lambda._00_brains.BrainCat;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        var cats = List.of(
                new BrainCat("Mur", 10),
                new BrainCat("Murka", 6),
                new BrainCat("Vaska", 14),
                new BrainCat("Mashka", 2)

        );

        var stream = cats.stream()
                .filter(cat -> cat.getAge() > 3)
                .filter(cat -> cat.getName().length() >= 5);
//map
        cats.stream()
                .map(BrainCat::getName);
        List.of(
                        new FlatMapCat("cat1", 5, List.of("Mouse", "Ball")),
                        new FlatMapCat("cat2", 5, List.of("Toy1", "Toy2"))

                ).stream().flatMap(cat -> cat.getToys().stream())
                .collect(Collectors.toList()).forEach(System.out::println);
//forEach
        cats.forEach(System.out::println);
//max
        System.out.println("Cat->" + cats.stream()
                .max(new FlatMapComparator()).get());
        System.out.println("====================================");
//sorted
        cats.stream()
                .sorted().forEach(it -> System.out.print("Cats->" + it + ","));
        System.out.println();
        System.out.println("====================================");
        cats.stream()
                .sorted(new FlatMapComparator())
                .forEach(it -> System.out.print("Cats->" + it + ","));

        var brainCatsStream = cats.stream();
        var flatMapCatStream = List.of(
                new FlatMapCat("cat1", 5, List.of("Mouse", "Ball")),
                new FlatMapCat("cat2", 5, List.of("Toy1", "Toy2"))

        ).stream().map(cat -> new BrainCat(cat.getName(), cat.getAge()));
        System.out.println();
        System.out.println("*********   concat  ************");
//concat
        Stream.concat(brainCatsStream, flatMapCatStream).forEach(System.out::print);
        System.out.println();
        System.out.println("**********  distinct  ***********");
        var numbers = List.of(1, 2, 2, 4, 4, 5, 5);

        numbers.stream()
                .distinct()
                .forEach(System.out::print);
        System.out.println();
        System.out.println("*********  Skip&Limit  ************");
        var numbers1 = List.of(1, 2, 3, 4, 5, 6, 7);
        numbers1.stream().skip(2).limit(3).forEach(System.out::print);
        System.out.println();
        System.out.println("============");

        //count
        System.out.println("*********  Count  ************");
        System.out.println(cats.stream().count());

        //findFirst
        System.out.println();
        System.out.println("*********  findFirst  ************");
        System.out.println(cats.stream().findFirst().get());

        //findAny
        System.out.println();
        System.out.println("*********  findAny  ************");
        System.out.println(cats.stream().findAny().get());

        //allMatch
        System.out.println();
        System.out.println("*********  allMatch  ************");
        System.out.println(cats.stream().allMatch(cat -> cat.getName().length() >= 3));
        System.out.println(cats.stream().allMatch(cat -> cat.getAge() > 5));

        //anyMatch
        System.out.println();
        System.out.println("*********  anyMatch  ************");
        System.out.println(cats.stream().anyMatch(cat -> cat.getAge() > 5));

        //noneMatch
        System.out.println();
        System.out.println("*********  noneMatch  ************");
        System.out.println(cats.stream().noneMatch(cat -> cat.getAge() < 1));

        //max
        System.out.println();
        System.out.println("*********  max  ************");
        System.out.println("Cat->" + cats.stream()
                .max(new FlatMapComparator()).get());

        //min
        System.out.println();
        System.out.println("*********  min  ************");
        System.out.println("Cat->" + cats.stream()
                .min(new FlatMapComparator()).get());

        //reduce(BinaryOperator<T> accumulator)
        System.out.println();
        System.out.println("*********  Reduce1  ************");
        Stream<Integer> numbersStream = Stream.of(1, 2, 3, 4, 5, -1, -2, -3, -4, -5);
        //System.out.println(numbersStream.reduce(Integer::sum));
        //System.out.println(numbersStream.reduce((x, y) -> x + y).get());
        System.out.println(numbersStream.reduce((x, y) -> x * y).get());
        System.out.println(Stream.of(1, 2, 3, 4, 5, -1, -2, -3, -4, -5).reduce((x, y) -> x * y).get());

        //reduce(T identity,BinaryOperator<T> accumulator)
        System.out.println();
        System.out.println("*********  Reduce2  ************");
        System.out.println(Stream.<Integer>empty().reduce(5, (x, y) -> x + y));
        System.out.println(Stream.of(1, 2, 3, 4, 5, -1, -2, -3, -4, -5).reduce(1, (x, y) -> x + y));
        System.out.println(Stream.of(1, 2, 3, 4, 5, -1, -2, -3, -4, -5).reduce(0, (x, y) -> x * y));

        //reduce
        System.out.println();
        System.out.println("*********  Reduce3  ************");
        Stream<BrainCat> catStream = Stream.of(
                new BrainCat("Cat1", 1),
                new BrainCat("Cat2", 5),
                new BrainCat("Cat3", 4),
                new BrainCat("Cat4", 2)
        );

        int sum = catStream.reduce(0,
                (x, y) -> {
                    if (y.getAge() < 3) {
                        return x + y.getAge();
                    } else
                        return x + 0;
                }, (x, y) -> x + y);

        System.out.println(sum);

        //collect
        //<R, A> R collect(Collector<? super T, A, R> collector);
        System.out.println();
        System.out.println("*********  Collect  ************");

        var adultCats = cats.stream()
                .filter(cat -> cat.getAge() > 5)
                //.toList()
                .collect(Collectors.toList());
        System.out.println(adultCats.getClass().getName());
        for (BrainCat adultCat : adultCats) {
            System.out.println(adultCat);
        }

        var adultCats1 = cats.stream()
                .filter(cat -> cat.getAge() > 5)
                //.toList()
                .collect(Collectors.toSet());
        System.out.println(adultCats1.getClass().getName());
        for (BrainCat adultCat1 : adultCats) {
            System.out.println(adultCat1);
        }
        System.out.println("================");
        Map<String, Integer> catsMap = cats.stream()
                .collect(Collectors.toMap(k -> k.getName(), v -> v.getAge()));

        catsMap.forEach((k, v) -> System.out.println(k + " " + v));

        cats.stream()
                .filter(cat -> StringUtils.startsWith(cat.getName(), "M"))
                .collect(Collectors.toCollection(LinkedList::new))
                .forEach(System.out::println);

        //parallel
        System.out.println();
        System.out.println("*********  Parallel  ************");
        var people = List.of("Tom", "Bob", "Sam", "Kate", "Tim", "Ann");
        people.stream()
                .filter(p -> p.length() == 3)
                .forEach(p -> System.out.print(p + ","));
        System.out.println();
        people.parallelStream()
                .filter(p -> p.length() == 3)
                .forEach(p -> System.out.print(p + ","));

    }
}
