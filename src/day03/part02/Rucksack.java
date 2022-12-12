package day03.part02;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public record Rucksack(List<String> comp1, List<String> comp2) {
    public static Rucksack fromString (String items) {
        int mitte = items.length() /2;
        final List<String> comp1 = Arrays.stream(items.substring(0, mitte).split("")).toList();
        final List<String> comp2 = Arrays.stream(items.substring(mitte).split("")).toList();
        return new Rucksack(comp1, comp2);
    }

    List<String> getItems(){
        return Stream.of(comp1, comp2).flatMap(Collection::stream).toList();
    }

    public Set<String> getPrioItems(){
        return comp1.stream().filter(comp2::contains).collect(Collectors.toSet());
    }

    public int getScoreFuerPrioItems() {
        final Map<String, Integer> itemValues = getItemValues();
        return getPrioItems().stream().mapToInt(itemValues::get).sum();
    }

    private static Map<String, Integer> getItemValues() {
        BiFunction<List<String>, Integer, Map<String, Integer>> getPoints = (list, offset) -> IntStream.range(0, list.size()).boxed().collect(Collectors.toMap(list::get, x -> x + offset));
        BiFunction<Character, Character, List<String>> getLetters = (start, end) -> IntStream.rangeClosed(start, end).mapToObj(c -> "" + (char) c).toList();
        final List<String> AZ = getLetters.apply('A', 'Z');
        final List<String> az = getLetters.apply('a', 'z');
        final Map<String, Integer> AZPoints = getPoints.apply(AZ, 27);
        final Map<String, Integer> azPoints = getPoints.apply(az, 1);
        return Stream.concat(azPoints.entrySet().stream(), AZPoints.entrySet().stream()).collect(
                Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
