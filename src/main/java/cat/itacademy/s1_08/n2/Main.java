package cat.itacademy.s1_08.n2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    // Ex1 - Names starting with 'A' and exactly 3 letters
    public static List<String> filterNamesStartingWithA(List<String> names) {
        return names.stream()
                .filter(name -> name.startsWith("A") && name.length() == 3)
                .collect(Collectors.toList());
    }

    // Ex2 - Comma separated string with e/o prefix
    public static String formatNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> (n % 2 == 0 ? "e" : "o") + n)
                .collect(Collectors.joining(", "));
    }

    public static void main(String[] args) {

        // Ex1
        System.out.println("─".repeat(40));
        System.out.println("Ex1 - Names starting with 'A' and exactly 3 letters:");
        List<String> names = Arrays.asList("Ana", "Alberto", "Ali", "Bob", "Amy", "Ann", "Al", "Alice");
        System.out.println(filterNamesStartingWithA(names));

        // Ex2
        System.out.println("─".repeat(40));
        System.out.println("Ex2 - Numbers with e/o prefix:");
        List<Integer> numbers = Arrays.asList(3, 55, 44, 12, 7, 100);
        System.out.println(formatNumbers(numbers));

        // Ex3 - Functional Interface with arithmetic operations
        System.out.println("─".repeat(40));
        System.out.println("Ex3 - Arithmetic operations via functional interface:");
        float a = 10f;
        float b = 3f;

        OperacioInterface sum = () -> a + b;
        OperacioInterface subtract = () -> a - b;
        OperacioInterface multiply = () -> a * b;
        OperacioInterface divide = () -> a / b;

        System.out.println("Sum:      " + sum.operacio());
        System.out.println("Subtract: " + subtract.operacio());
        System.out.println("Multiply: " + multiply.operacio());
        System.out.println("Divide:   " + divide.operacio());

        // Ex4 - Sort, filter and modify list
        System.out.println("─".repeat(40));
        System.out.println("Ex4a - Sorted alphabetically by first character:");
        List<String> mixedList = Arrays.asList("banana", "apple", "42", "cherry", "7", "avocado", "15", "elderberry");
        List<String> sortedAlpha = mixedList.stream()
                .sorted(Comparator.comparingInt(s -> s.charAt(0)))
                .collect(Collectors.toList());
        System.out.println(sortedAlpha);

        System.out.println("─".repeat(40));
        System.out.println("Ex4b - Strings containing 'e' first:");
        List<String> sortedEFirst = mixedList.stream()
                .sorted((s1, s2) -> {
                    boolean s1HasE = s1.contains("e");
                    boolean s2HasE = s2.contains("e");
                    if (s1HasE && !s2HasE) return -1;
                    if (!s1HasE && s2HasE) return 1;
                    return 0;
                })
                .collect(Collectors.toList());
        System.out.println(sortedEFirst);

        System.out.println("─".repeat(40));
        System.out.println("Ex4c - Replace 'a' with '4':");
        List<String> replaced = mixedList.stream()
                .map(s -> s.replace('a', '4'))
                .collect(Collectors.toList());
        System.out.println(replaced);

        System.out.println("─".repeat(40));
        System.out.println("Ex4d - Only numeric elements:");
        List<String> numeric = mixedList.stream()
                .filter(s -> s.chars().allMatch(Character::isDigit))
                .collect(Collectors.toList());
        System.out.println(numeric);
    }
}