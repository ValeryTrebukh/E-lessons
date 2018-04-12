package task06;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runner {
    public void run() {
        printInts();

        List<Person> people = createPeople();

        people.stream()
                .filter(p -> (p.getSex()==Sex.MAIL && (p.getAge() >= 18 && p.getAge() <= 27)))
                .forEach(p -> System.out.println(p.toString()));

        Double average = people.stream()
                .filter(p -> p.getSex() == Sex.FEMAIL)
                .mapToInt(Person::getAge)
                .average().getAsDouble();

    }

    private List<Person> createPeople() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Peter", Sex.MAIL, 25));
        people.add(new Person("Sandeep", Sex.MAIL, 45));
        people.add(new Person("Ann", Sex.FEMAIL, 18));
        people.add(new Person("Abdul", Sex.MAIL, 20));
        people.add(new Person("Adelle", Sex.FEMAIL, 33));
        people.add(new Person("Yorik", Sex.MAIL, 225));
        people.add(new Person("Iow", Sex.MAIL, 27));
        people.add(new Person("Jeanne", Sex.FEMAIL, 15));

        return people;
    }

    private void printInts() {
        Stream.iterate(10, n -> n + 10)
                .limit(10)
                .map(n -> n / 2)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }


}
