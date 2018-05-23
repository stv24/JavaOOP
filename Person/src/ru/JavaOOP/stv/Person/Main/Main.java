package ru.JavaOOP.stv.Person.Main;

import ru.JavaOOP.stv.Person.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(new Person("Pavel", 22), new Person("Mariya", 27),
                new Person("Igor", 30), new Person("Igor", 17));

        List<String> distinctNames = persons.stream().
                map(p -> p.getName()).distinct().collect(Collectors.toList());

        String names = distinctNames.toString();
        System.out.println(distinctNames.stream().
                collect(Collectors.joining(", ", "Names: ", ".")));
        Stream<Person> stream = persons.stream().distinct();

        List<Person> peoplesYounger18 = persons.stream().
                filter(p -> p.getAge() < 18).collect(Collectors.toList());

        OptionalDouble averageAge = peoplesYounger18.stream().mapToInt(p -> p.getAge()).average();

        Map<String, List<Person>> personsByName = persons.stream().collect(Collectors.groupingBy(p -> p.getName()));
        Map<String, OptionalDouble> averageAges = personsByName.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue()
                .stream().mapToInt(p -> p.getAge()).average()));

        List<Person> personsRange = persons.stream().filter(p -> p.getAge() > 20 && p.getAge() < 45)
                .collect(Collectors.toList());

        personsRange.stream().sorted((p1, p2) -> (p2.getAge() - p1.getAge())).forEach(p -> System.out.println(p.getName()));
    }
}
