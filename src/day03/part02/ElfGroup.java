package day03.part02;


import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public record ElfGroup(Rucksack elf1, Rucksack elf2, Rucksack elf3) {

 /*   public Set<String> getPrioItems(){
        return comp1.stream().filter(comp2::contains).collect(Collectors.toSet());
    } */

    public Set<String> getBadgeItems() {
        return elf1.getItems().stream().filter(elf2.getItems()::contains).filter(elf3.getItems()::contains).collect(Collectors.toSet());
    }

    public int getScoreFuerBadgeItems() {
        final Map<String, Integer> itemValues = getItemValues();
        return getBadgeItems().stream().mapToInt(itemValues::get).sum();
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
