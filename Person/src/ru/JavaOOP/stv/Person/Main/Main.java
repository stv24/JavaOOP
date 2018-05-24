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
                map(Person::getName).distinct().collect(Collectors.toList());

        String names = distinctNames.toString();
        System.out.println(distinctNames.stream().
                collect(Collectors.joining(", ", "Names: ", ".")));
        Stream<Person> stream = persons.stream().distinct();

        List<Person> peoplesYounger18 = persons.stream().
                filter(p -> p.getAge() < 18).collect(Collectors.toList());

        OptionalDouble averageAge = peoplesYounger18.stream().mapToInt(Person::getAge).average();

        Map<String, List<Person>> personsByName = persons.stream().collect(Collectors.groupingBy(Person::getName));

        Map<String, Double> averageAges = persons.stream().collect(Collectors.
                groupingBy(Person::getName, Collectors.averagingInt(Person::getAge)));

        List<Person> personsRange = persons.stream().filter(p -> p.getAge() > 20 && p.getAge() < 45)
                .sorted((p1, p2) -> (p2.getAge() - p1.getAge())).collect(Collectors.toList());

        personsRange.forEach(p -> System.out.println(p.getName()));
    }
}
