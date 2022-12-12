package day03.part02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;


public class D03P2 {
    public static final String EXAMPLE = "src/day03/example.txt";
    public static final String INPUT = "src/day03/input.txt";

    public static void main(String[] args) {
        // hole Rucksaecke
        List<ElfGroup> groups = getElfGruppen(INPUT);

        System.out.println(groups.stream().mapToInt(ElfGroup::getScoreFuerBadgeItems).sum());

    }

    public static List<ElfGroup> getElfGruppen(String file) {
        List<Rucksack> elfen = readFile(file).stream().map(Rucksack::fromString).toList();
        List<ElfGroup> groups = new ArrayList<>();
        for (int i = 0; i+2 < elfen.size(); i+=3) {
            groups.add( new ElfGroup(
                    elfen.get(i),
                    elfen.get(i+1),
                    elfen.get(i+2)
            ) );
        }
        return groups;
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
