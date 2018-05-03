package ru.JavaOOP.stv.Person.Main;

import ru.JavaOOP.stv.Person.Person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        List<Person> persons = Arrays.asList(new Person("Pavel", 22), new Person("Mariya", 27),
                new Person("Igor", 30), new Person("Igor", 17));
        persons.stream().distinct();
      //  String allNamesString = persons.stream().map(p->p.getName().collect(Collectors.joining(","));

    }
}
