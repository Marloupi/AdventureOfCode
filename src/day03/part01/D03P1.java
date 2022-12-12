package day03.part01;

import day02.part1.Match;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class D03P1 {
    public static final String EXAMPLE = "src/day03/example.txt";
    public static final String INPUT = "src/day03/input.txt";

    public static void main(String[] args) {
        // hole Rucksaecke
        List<Rucksack> liste = readFile(INPUT).stream().map(Rucksack::fromString).toList();

        System.out.println(liste.stream().mapToInt(Rucksack::getScoreFuerPrioItems).sum());

    }

    public static List<String> readFile(String file){
        try {
            Path fileName = Paths.get(file);
            return Files.readAllLines(fileName);
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }


    public List<String> holePrioItems(Rucksack r) {
        Set<String> prioItems = r.getPrioItems();
        return new ArrayList<>(prioItems);
    }

}
