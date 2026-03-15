package cat.itacademy.s1_08.n1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    // Ex1 - Filter strings containing 'o'
    public static List<String> filterContainingO(List<String> strings) {
        return strings.stream()
                .filter(s -> s.contains("o"))
                .collect(Collectors.toList());
    }

    // Ex2 - Filter strings containing 'o' AND more than 5 letters
    public static List<String> filterContainingOAndLongerThan5(List<String> strings) {
        return strings.stream()
                .filter(s -> s.contains("o") && s.length() > 5)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("hello", "world", "java", "stream", "option", "foo", "programming");

        System.out.println("─".repeat(40));
        System.out.println("Ex1 - Strings containing 'o':");
        System.out.println(filterContainingO(words));

        System.out.println("─".repeat(40));
        System.out.println("Ex2 - Strings containing 'o' AND longer than 5:");
        System.out.println(filterContainingOAndLongerThan5(words));

        // Ex3 - Print months with lambda
        System.out.println("─".repeat(40));
        System.out.println("Ex3 - Months with lambda:");
        List<String> months = Arrays.asList(
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        );
        months.forEach(month -> System.out.println(month));

        // Ex4 - Print months with method reference
        System.out.println("─".repeat(40));
        System.out.println("Ex4 - Months with method reference:");
        months.forEach(System.out::println);

        // Ex5 - Functional Interface PiValue
        System.out.println("─".repeat(40));
        System.out.println("Ex5 - Pi value via functional interface:");
        PiValueInterface pi = () -> 3.1415;
        System.out.println("Pi = " + pi.getPiValue());

        // Ex6 - Sort strings shortest to longest
        System.out.println("─".repeat(40));
        System.out.println("Ex6 - Sorted shortest to longest:");
        List<String> mixed = Arrays.asList("banana", "hi", "java", "ok", "programming", "cat");
        List<String> sortedAsc = mixed.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        System.out.println(sortedAsc);

        // Ex7 - Sort strings longest to shortest
        System.out.println("─".repeat(40));
        System.out.println("Ex7 - Sorted longest to shortest:");
        List<String> sortedDesc = mixed.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .collect(Collectors.toList());
        System.out.println(sortedDesc);

        // Ex8 - Functional Interface Reverse
        System.out.println("─".repeat(40));
        System.out.println("Ex8 - Reverse string via functional interface:");
        ReverseInterface reverser = input -> new StringBuilder(input).reverse().toString();
        String original = "Hello World";
        String reversed = reverser.reverse(original);
        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reversed);
    }
}